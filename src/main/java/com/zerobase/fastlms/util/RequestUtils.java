package com.zerobase.fastlms.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    public static String getClientIp(HttpServletRequest request) {

        String ip = null;

        ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("Proxy-Client-IP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("WL-Proxy-Client-IP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("HTTP_CLIENT_IP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("HTTP_X_FORWARDED_FOR");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("X-Real-IP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("X-RealIP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("REMOTE_ADDR");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getRemoteAddr();

        }

        return ip;

    }  public static String getUserAgent(HttpServletRequest request) {

        String userAgent = null;
        userAgent = request.getHeader("user-agent");

        return userAgent;

    }

}
