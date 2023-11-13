package com.lv.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lv.shortlink.project.common.convention.result.Result;
import com.lv.shortlink.project.common.convention.result.Results;
import com.lv.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.lv.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 修改短链接
     * @return
     */
    @PostMapping("/api/short-link/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam){
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
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

    /**
     * 查询短链接分组内数量
     */
    @GetMapping("/api/short-link/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam){
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }
}
