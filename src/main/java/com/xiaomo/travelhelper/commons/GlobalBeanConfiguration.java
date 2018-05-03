package com.xiaomo.travelhelper.commons;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * bean 配置类
 */
@Configuration
public class GlobalBeanConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(HttpBasicAuthorizeFilter httpBasicFilter) {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(httpBasicFilter);
        return registrationBean;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/upload/**").addResourceLocations("file:C:\\Users\\mojiale\\Desktop\\OA\\TravelHelperServer\\src\\main\\resources\\upload\\");
        registry.addResourceHandler("/temp/**").addResourceLocations("file:C:\\Users\\mojiale\\Desktop\\OA\\TravelHelperServer\\src\\main\\resources\\templates\\");
        registry.addResourceHandler("/static/**").addResourceLocations("file:C:\\Users\\mojiale\\Desktop\\OA\\TravelHelperServer\\src\\main\\resources\\static\\");
    }
}
