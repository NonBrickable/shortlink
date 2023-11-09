package com.lv.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lv.shortlink.admin.dao.entity.GroupDO;
import com.lv.shortlink.admin.dao.mapper.GroupMapper;
import com.lv.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.lv.shortlink.admin.service.GroupService;
import com.lv.shortlink.admin.toolkit.RandomGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短链接分组接口实现层
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    @Override
    public void saveGroup(String groupName) {
        String gid;
        do {
            gid = RandomGenerator.generateRandomString();
        } while (!hasGid(gid));
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(groupName)
                .build();
        // TODO: 2023/11/8 设置创建用户
        baseMapper.insert(groupDO);
    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        // TODO: 2023/11/9 获取用户名
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag,0)
                .eq(GroupDO::getUsername, "lvcq2")
                .orderByDesc(GroupDO::getSortOrder,GroupDO::getUpdateTime);
        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(groupDOList,ShortLinkGroupRespDTO.class);
    }

    /**
     * 判断pid是否可用
     * @param gid
     * @return
     */
    private Boolean hasGid(String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid);
        GroupDO groupDO = baseMapper.selectOne(queryWrapper);
        return groupDO == null;
    }
}