package com.lv.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.admin.dao.entity.UserDO;
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
}
