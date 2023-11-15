package com.lv.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.project.dao.entity.ShortLinkDO;
import com.lv.shortlink.project.dto.req.RecycleBinSaveRespDTO;
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
    void saveRecycleBin(RecycleBinSaveRespDTO requestParam);

    /**
     * 分页查询回收站
     * @param requestParam
     * @return
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecyclePageReqDTO requestParam);
}
