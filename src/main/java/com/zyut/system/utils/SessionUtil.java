package com.zyut.system.utils;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;


public class SessionUtil {
    private static final Long sessionMaxAge = 86400L;

    private SessionUtil() {

    }

    private static class SessionUtilInner {
        private static final SessionUtil SESSION_UTIL = new SessionUtil();
    }

    public static SessionUtil getSessionUtil() {
        return SessionUtilInner.SESSION_UTIL;
    }

    private static ConcurrentHashMap<String, HttpSession> sessionMap;

    static {
        sessionMap = new ConcurrentHashMap<>();
    }

    public static ConcurrentHashMap<String, HttpSession> getSessionMap() {
        sessionMap = cleanMap(sessionMap);
        return sessionMap;
    }

    private static synchronized ConcurrentHashMap<String, HttpSession> cleanMap(
            ConcurrentHashMap<String, HttpSession> map) {
        if (map.size() < 1) {
            return map;
        }

        Set<Entry<String, HttpSession>> entrySet = map.entrySet();
        List<String> list = new ArrayList<>();
        for (Entry<String, HttpSession> entry : entrySet) {
            // 如果session过期了，就清除掉这个session
            long max_age = sessionMaxAge * 1000L;
            long time = new Date().getTime();
            long creationTime = entry.getValue().getCreationTime();
            long sessionAge = time - creationTime;
            if (sessionAge > max_age) {
                list.add(entry.getKey());
                entry.getValue().setMaxInactiveInterval(1);
            }
        }

        if (list.size() > 0) {
            for (String s : list) {
                map.remove(s);
            }
        }
        return map;
    }

    public static synchronized void cleanOldSession(String userInfo) {
        if (sessionMap != null && sessionMap.size() > 0) {
            Set<Entry<String, HttpSession>> entrySet = sessionMap.entrySet();
            String sessionKey = "";
            for (Entry<String, HttpSession> entry : entrySet) {
                if (StrUtil.isNotBlank(userInfo)
                        && userInfo.equals(entry.getValue().getAttribute("userInfo"))) {
                    sessionKey = entry.getKey();
                    entry.getValue().setMaxInactiveInterval(1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            if (StrUtil.isNotBlank(sessionKey)) {
                sessionMap.remove(sessionKey);
            }
        }
    }
}