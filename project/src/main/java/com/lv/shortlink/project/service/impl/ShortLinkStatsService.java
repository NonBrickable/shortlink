package com.lv.shortlink.project.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lv.shortlink.project.dto.req.ShortLinkGroupStatsAccessRecordReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * 短链接监控接口
 */
public interface ShortLinkStatsService {

    /**
     * 访问单个短链接指定时间内监控数据
     *
     * @param requestParam 传入参数
     * @return
     */
    ShortLinkStatsRespDTO shortLinkStats(ShortLinkStatsReqDTO requestParam);

    /**
     * 获取分组短链接监控数据
     *
     * @param requestParam 获取分组短链接监控数据入参
     * @return 分组短链接监控数据
     */
    ShortLinkStatsRespDTO groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam);

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam 获取短链接监控访问记录数据入参
     * @return 访问记录监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);

    /**
     * 访问分组短链接指定时间内访问记录监控数据
     *
     * @param requestParam 获取分组短链接监控访问记录数据入参
     * @return 分组访问记录监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam);
}
