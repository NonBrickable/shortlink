package com.lv.shortlink.admin.remote.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接移除功能
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecycleBinRemoveReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;
}
