package com.lv.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.admin.dao.entity.UserDO;
import com.lv.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.lv.shortlink.admin.dto.resp.UserRespDTO;

/**
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名查询用户信息
     * @return
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否已存在
     * @param username
     * @return 用户名存在：flase 不存在: true(可以用来注册)
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     * @param requestParam 注册用户请求参数
     */
    void register(UserRegisterReqDTO requestParam);
}
