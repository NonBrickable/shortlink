package com.lv.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.admin.dao.entity.GroupDO;
import com.lv.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.lv.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.lv.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * 短链接分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 添加短链接分组
     * @param groupName
     */
    void saveGroup(String groupName);

    /**
     * 短视频分组
     * @param username
     * @param groupName
     */
    void saveGroup(String username,String groupName);

    /**
     * 查询用户短链接分组集合
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 修改短链接分组
     * @param requestParam
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 删除用户分组
     */
    void deleteGroup(String gid);

    /**
     * 短链接分组排序
     * @param requestParam
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);


}
