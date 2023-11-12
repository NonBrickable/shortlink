package com.lv.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lv.shortlink.project.common.convention.result.Result;
import com.lv.shortlink.project.common.convention.result.Results;
import com.lv.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.lv.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;

    /**
     * 创建短链接
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        return Results.success(shortLinkService.createShorLink(requestParam));
    }

    /**
     * 分页查询短链接
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }
}
