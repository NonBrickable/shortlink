package com.lv.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.project.dao.entity.ShortLinkDO;
import com.lv.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkCreateRespDTO;

/**
 * 短链接接口层
 */
public interface ShortLinkService extends IService<ShortLinkDO> {
    /**
     * 创建短链接
     * @param requestParam
     * @return
     */
    ShortLinkCreateRespDTO createShorLink(ShortLinkCreateReqDTO requestParam);
}
