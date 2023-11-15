package com.lv.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lv.shortlink.project.common.convention.result.Result;
import com.lv.shortlink.project.common.convention.result.Results;
import com.lv.shortlink.project.dto.req.RecycleBinSaveRespDTO;
import com.lv.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkRecyclePageReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.lv.shortlink.project.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {
    private final RecycleBinService recycleBinService;

    /**
     * 保存回收站
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveRespDTO requestParam){
        recycleBinService.saveRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询回收站
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecyclePageReqDTO requestParam){
        return Results.success(recycleBinService.pageShortLink(requestParam));
    }

}
