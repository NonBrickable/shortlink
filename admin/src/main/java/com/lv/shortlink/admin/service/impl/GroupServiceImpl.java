package com.lv.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lv.shortlink.admin.dao.entity.GroupDO;
import com.lv.shortlink.admin.dao.mapper.GroupMapper;
import com.lv.shortlink.admin.service.GroupService;
import org.springframework.stereotype.Service;

/**
 * 短链接分组接口实现层
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
}
