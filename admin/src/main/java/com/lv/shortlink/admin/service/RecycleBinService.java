package com.lv.shortlink.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lv.shortlink.admin.common.convention.result.Result;
import com.lv.shortlink.admin.remote.dto.req.ShortLinkRecyclePageReqDTO;
import com.lv.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;

/**
 * 回收站接口层
 */
public interface RecycleBinService {
    /**
     * 分页查询短链接
     * @param requestParam
     * @return
     */
    Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecyclePageReqDTO requestParam);
}
