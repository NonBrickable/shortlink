package com.lv.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.admin.dao.entity.GroupDO;

/**
 * 短链接分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 添加短链接分组
     * @param groupName
     */
    void saveGroup(String groupName);
}
