package com.lv.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.project.dao.entity.ShortLinkDO;
import com.lv.shortlink.project.dto.req.RecycleBinSaveRespDTO;

/**
 * 回收站接口层
 */
public interface RecycleBinService extends IService<ShortLinkDO> {
    /**
     * 保存回收站
     * @param requestParam
     */
    void saveRecycleBin(RecycleBinSaveRespDTO requestParam);
}
