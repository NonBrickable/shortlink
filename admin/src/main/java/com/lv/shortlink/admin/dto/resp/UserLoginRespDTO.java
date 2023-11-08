package com.lv.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户登录结果响应
 */
@Data
@AllArgsConstructor
public class UserLoginRespDTO {
    private String token;
}
