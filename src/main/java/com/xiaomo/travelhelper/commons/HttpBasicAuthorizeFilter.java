package com.xiaomo.travelhelper.commons;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaomo.travelhelper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限检验过滤器
 */
@Component("httpBasicAuthorizeFilter")
@WebFilter(filterName="httpBasicAuthorizeFilter",urlPatterns={"/*"})
public class HttpBasicAuthorizeFilter implements Filter{

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/login", "/logout", "/register","/isonline")));

    @Autowired
    private RedisClient redisClient;

    public HttpBasicAuthorizeFilter(RedisClient redisClient){
        this.redisClient = redisClient;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //System.out.println("doFilter-check-account-token");
        if(isAllowed((HttpServletRequest) request) || true){
            chain.doFilter(request,response);
        }else{
            String account = request.getParameter("account");
            String token = request.getParameter("token");
            ResultMessage resultMessage;
            if(StringUtils.isEmpty(account) || StringUtils.isEmpty(token)){
                resultMessage = ResultMessage.buildByFail("参数异常");
            }else{
                if(redisClient.isHasKey(account) && token.equals(redisClient.get(account))){
                    long timeout = redisClient.getExpire(account);
                    // 缓存剩余时间低于 10 分钟刷新缓存
                    if(timeout < 60*10){
                        redisClient.add(account,token);
                    }
                    resultMessage = ResultMessage.buildBySuccess();
                }else{
                    resultMessage = ResultMessage.buildByFail("你还没登录,请退出再登录");
                }
            }
            // 通过校验或不通过直接返回
            if(resultMessage.isSuccess()){
                chain.doFilter(request,response);
            }else{
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(resultMessage);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                response.getWriter().write(json);
            }
        }
    }

    @Override
    public void destroy() {

    }

    boolean isAllowed(HttpServletRequest request) {
        String path = request.getRequestURI();
        String extension = path.substring(path.lastIndexOf('/')).toLowerCase();
        return ALLOWED_PATHS.contains(extension);
    }
}
