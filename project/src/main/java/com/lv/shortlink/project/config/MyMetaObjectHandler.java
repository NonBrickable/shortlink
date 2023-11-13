package com.lv.shortlink.project.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充配置
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", () -> new Date(), Date.class);
        this.strictInsertFill(metaObject, "updateTime", () -> new Date(), Date.class);
        this.strictInsertFill(metaObject, "delFlag", () -> 0, Integer.class);
        this.strictInsertFill(metaObject, "sortOrder", () -> 0, Integer.class);
        this.strictInsertFill(metaObject, "enableStatus", () -> 0, Integer.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", () -> new Date(), Date.class);
    }
}