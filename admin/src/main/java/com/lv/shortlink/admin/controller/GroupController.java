package com.lv.shortlink.admin.controller;

import com.lv.shortlink.admin.common.convention.result.Result;
import com.lv.shortlink.admin.common.convention.result.Results;
import com.lv.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.lv.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.lv.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.lv.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短视频分组控制层
 */
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    /**
     * 新增短链接分组
     */
    @PostMapping("api/short-link/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    /**
     * 查询短链接分组
     */
    @GetMapping("api/short-link/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

    /**
     * 修改短链接分组名称
     */
    @PutMapping("api/short-link/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam){
        groupService.updateGroup(requestParam);
        return Results.success();
    }

}
