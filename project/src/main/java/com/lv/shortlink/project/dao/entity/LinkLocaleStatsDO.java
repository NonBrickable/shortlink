package com.lv.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lv.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 地区访问统计实体
 */
@Data
@TableName("t_link_locale_stats")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LinkLocaleStatsDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 日期
     */
    private Date date;

    /**
     * 访问量
     */
    private Integer cnt;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份名称
     */
    private String province;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 城市的adcode编码
     */
    private String adcode;
}
