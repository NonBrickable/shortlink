package com.lv.shortlink.admin.controller;

import com.lv.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroupController {
    private GroupService groupService;
}
