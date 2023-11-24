package com.lv.shortlink.project.service.impl;

import com.lv.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * 短链接监控接口
 */
public interface ShortLinkStatsService {

    /**
     * 访问单个短链接指定时间内监控数据
     * @param requestParam 传入参数
     * @return
     */
    ShortLinkStatsRespDTO shortLinkStats(ShortLinkStatsReqDTO requestParam);
}
