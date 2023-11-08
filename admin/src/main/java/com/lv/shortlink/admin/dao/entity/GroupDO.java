package com.lv.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 短链接分组实体
 */
@Data
@TableName("t_group")
public class GroupDO {
    /**
     * id
     */
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建人
     */
    private String username;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更改时间
     */
    private Date updateTime;

    /**
     * 删除标识 0：没有删除 1：删除删除标识
     */
    private int delFlag;
}
