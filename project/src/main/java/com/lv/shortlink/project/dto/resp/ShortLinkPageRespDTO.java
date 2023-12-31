package com.lv.shortlink.project.dto.resp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 短链接分页返回参数
 */
@Data
public class ShortLinkPageRespDTO extends Page {
    /**
     * 域名
     */
    private String domain;

    /**
     * 短链接uri
     */
    private String shortUri;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 有效期类型：0：永久有效 1：自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date validDate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 描述
     */
    private String describe;

    /**
     * 图标
     */
    private String favicon;

    /**
     * 历史uv
     */
    private Integer totalUv;

    /**
     * 今日pv
     */
    private Integer todayUv;

    /**
     * 历史pv
     */
    private Integer totalPv;

    /**
     * 今日pv
     */
    private Integer todayPv;

    /**
     * 历史uip
     */
    private Integer totalUip;

    /**
     * 今日uip
     */
    private Integer todayUip;

}
