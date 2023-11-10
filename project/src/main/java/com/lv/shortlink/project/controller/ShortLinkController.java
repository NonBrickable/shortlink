package com.lv.shortlink.project.controller;

import com.lv.shortlink.project.common.convention.result.Result;
import com.lv.shortlink.project.common.convention.result.Results;
import com.lv.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.lv.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;
    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        return Results.success(shortLinkService.createShorLink(requestParam));
    }
}
