package com.lv.shortlink.admin.remote.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 回收站保存功能
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecycleBinSaveRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;
}
