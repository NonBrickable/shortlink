package com.lv.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lv.shortlink.admin.common.biz.user.UserContext;
import com.lv.shortlink.admin.common.convention.result.Result;
import com.lv.shortlink.admin.dao.entity.GroupDO;
import com.lv.shortlink.admin.dao.mapper.GroupMapper;
import com.lv.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.lv.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.lv.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.lv.shortlink.admin.remote.ShortLinkRemoteService;
import com.lv.shortlink.admin.remote.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.lv.shortlink.admin.service.GroupService;
import com.lv.shortlink.admin.toolkit.RandomGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短链接分组接口实现层
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };
    @Override
    public void saveGroup(String groupName) {
        saveGroup(UserContext.getUsername(),groupName);
    }

    @Override
    public void saveGroup(String username, String groupName) {
        String gid;
        do {
            gid = RandomGenerator.generateRandomString();
        } while (!hasGid(username,gid));
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(groupName)
                .username(username)
                .build();
        baseMapper.insert(groupDO);
    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .orderByDesc(GroupDO::getSortOrder, GroupDO::getUpdateTime);
        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
        Result<List<ShortLinkGroupCountQueryRespDTO>> listResult = shortLinkRemoteService.listGroupShortLinkCount(groupDOList.stream().map(GroupDO::getGid).toList());
        List<ShortLinkGroupRespDTO> shortLinkGroupRespDTOList = BeanUtil.copyToList(groupDOList, ShortLinkGroupRespDTO.class);
        for(ShortLinkGroupRespDTO resp:shortLinkGroupRespDTOList){
            for(ShortLinkGroupCountQueryRespDTO each:listResult.getData()){
                if(resp.getGid().equals(each.getGid())){
                    resp.setShortLinkCount(each.getShortLinkCount());
                }
            }
        }
        return shortLinkGroupRespDTOList;
    }

    @Override
    public void updateGroup(ShortLinkGroupUpdateReqDTO requestParam) {
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, requestParam.getGid());
        GroupDO groupDO = new GroupDO();
        groupDO.setName(requestParam.getName());
        baseMapper.update(groupDO, updateWrapper);
    }

    @Override
    public void deleteGroup(String gid) {
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, gid);
        GroupDO groupDO = new GroupDO();
        groupDO.setDelFlag(1);
        baseMapper.update(groupDO, updateWrapper);
    }

    @Override
    public void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam) {
        requestParam.forEach(each -> {
            GroupDO groupDO = GroupDO.builder()
                    .sortOrder(each.getSortOrder())
                    .build();
            LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                    .eq(GroupDO::getGid, each.getGid())
                    .eq(GroupDO::getDelFlag, 0)
                    .eq(GroupDO::getUsername, UserContext.getUsername());
            baseMapper.update(groupDO, updateWrapper);
        });
    }

    /**
     * 判断pid是否可用
     *
     * @return
     */
    private Boolean hasGid(String username,String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, username)
                .eq(GroupDO::getGid, gid);
        GroupDO groupDO = baseMapper.selectOne(queryWrapper);
        return groupDO == null;
    }

}
