package com.lv.shortlink.project.toolkit;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.Optional;

import static com.lv.shortlink.project.common.constant.ShortLinkConstant.DEFAULT_CACHE_VALID_TIME;

/**
 * 短链接工具类
 */
public class LinkUtil {
    /**
     * 获取短链接缓存应该设置的有效时间
     * @param validDate
     * @return
     */
    public static long getLinkCacheValidTime(Date validDate){
        return Optional.ofNullable(validDate)
                .map(each -> DateUtil.between(new Date(),each, DateUnit.MS))
                .orElse(DEFAULT_CACHE_VALID_TIME);
    }
    /**
     * 获取请求真实ip地址
     *
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        // 如果通过多级代理，X-Forwarded-For 的值会是多个 IP 地址，第一个 IP 地址才是真实 IP
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 检测用户发起请求的操作系统
     * @param request
     * @return
     */
    public static String getOs(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent != null) {
            // 使用一些常见的操作系统关键词来检测用户的操作系统
            if (userAgent.toLowerCase().contains("windows")) {
                return "Windows";
            } else if (userAgent.toLowerCase().contains("mac")) {
                return "Macintosh";
            } else if (userAgent.toLowerCase().contains("x11")) {
                return "Unix";
            } else if (userAgent.toLowerCase().contains("android")) {
                return "Android";
            } else if (userAgent.toLowerCase().contains("iphone") || userAgent.toLowerCase().contains("ipad")) {
                return "iOS";
            } else {
                return "Unknown";
            }
        }

        return "Unknown";
    }
}
