package com.lv.shortlink.admin.common.biz.user;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户信息传输过滤器
 */
@RequiredArgsConstructor
public class UserTransmitFilter implements Filter {
    private final StringRedisTemplate stringRedisTemplate;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String username = httpServletRequest.getHeader("username");
        String token = httpServletRequest.getHeader("token");
        String requestURI = httpServletRequest.getRequestURI();
        Set<String> set = new HashSet<>();
        set.add("/api/short-link/admin/v1/user/login");
        set.add("/api/short-link/admin/v1/user");
        set.add("/api/short-link/admin/v1/user/check-login");
        if (!set.contains(requestURI)) {
            Object userDOStr = stringRedisTemplate.opsForHash().get("login_" + username, token);
            if (userDOStr != null) {
                UserInfoDTO userInfoDTO = JSON.parseObject(userDOStr.toString(), UserInfoDTO.class);
                UserContext.setUser(userInfoDTO);
            }
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.removeUser();
        }
    }
}