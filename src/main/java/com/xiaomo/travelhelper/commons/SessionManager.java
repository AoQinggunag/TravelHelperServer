package com.xiaomo.travelhelper.commons;

import com.google.common.collect.Maps;
import com.xiaomo.netty4chat.common.core.codec.AbstractResponseSerializer;
import com.xiaomo.netty4chat.common.core.start.Session;
import com.xiaomo.travelhelper.pojo.dto.OnLineDTO;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: 会话管理器
 */
public class SessionManager {

    /**
     * 在线会话
     */
    private static final Map<String, Session> onlineSessions = Maps.newConcurrentMap();

    /**
     * 加入
     * @param account
     * @return
     */
    public static boolean putSession(String account, Session session){
        if(!onlineSessions.containsKey(account)){
            boolean success = ((ConcurrentMap<String, Session>) onlineSessions).putIfAbsent(account, session)== null? true : false;
            return success;
        }
        return false;
    }

    /**
     * 移除
     * @param account
     */
    public static Session removeSession(String account){
        return onlineSessions.remove(account);
    }

    /**
     * 发送消息[自定义协议]
     * @param <T>
     */
    public static <T extends AbstractResponseSerializer> void sendMessage(String account,T message){
        Session session = onlineSessions.get(account);
        if (session != null && session.isConnected()) {
            session.write(message);
        }
    }


    /**
     * 是否在线
     * @param account
     * @return
     */
    public static boolean isOnlineUser(String account){
        return onlineSessions.containsKey(account);
    }

    /**
     * 获取所有在线用户
     * @return
     */
    public static Set<String> getOnlineUsers() {
        return Collections.unmodifiableSet(onlineSessions.keySet());
    }

    /**
     * 获取在线用户信息
     * @return
     */
    public static OnLineDTO getOnlineUser(String account) {
        Session session = onlineSessions.get(account);
        if(session == null){
            return null;
        }
        return (OnLineDTO) session.getAttachment();
    }

}
