package com.lv.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.project.dao.entity.ShortLinkDO;
import com.lv.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import com.lv.shortlink.project.dto.req.RecycleBinRemoveReqDTO;
import com.lv.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkRecyclePageReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkPageRespDTO;

/**
 * 回收站接口层
 */
public interface RecycleBinService extends IService<ShortLinkDO> {
    /**
     * 保存回收站
     * @param requestParam
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * 分页查询回收站
     * @param requestParam
     * @return
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecyclePageReqDTO requestParam);

    /**
     * 短链接恢复功能
     * @param requestParam
     */
    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);

    /**
     * 短链接移除功能
     * @param requestParam
     */
    void removeRecycleBin(RecycleBinRemoveReqDTO requestParam);
}
