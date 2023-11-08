package com.lv.shortlink.admin.controller;

import com.lv.shortlink.admin.common.convention.exception.ClientException;
import com.lv.shortlink.admin.common.convention.result.Result;
import com.lv.shortlink.admin.common.convention.result.Results;
import com.lv.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.lv.shortlink.admin.dto.req.UserLoginReqDTO;
import com.lv.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.lv.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.lv.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.lv.shortlink.admin.dto.resp.UserRespDTO;
import com.lv.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 查询用户名是否存在
     */
    @GetMapping("api/short-link/v1/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username){
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 注册用户
     */
    @PostMapping("api/short-link/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam){
        userService.register(requestParam);
        return Results.success();
    }

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("api/short-link/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username){
        UserRespDTO result = userService.getUserByUsername(username);
        if(result == null){
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        return Results.success(result);
    }

    /**
     * 修改用户
     */
    @PutMapping("api/short-link/v1/user")
    public Result<Void> update(@RequestBody UserUpdateReqDTO requestParam){
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * 用户登录
     */
    @PostMapping("api/short-link/v1/user/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO userLoginReqDTO){
        return Results.success(userService.login(userLoginReqDTO));
    }

    /**
     * 检查用户是否登录
     */
    @GetMapping("api/short-link/v1/user/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username,@RequestParam("token") String token){
        return Results.success(userService.checkLogin(username,token));
    }
}
