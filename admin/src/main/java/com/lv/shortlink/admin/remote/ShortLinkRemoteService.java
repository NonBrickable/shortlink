package com.lv.shortlink.admin.remote;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lv.shortlink.admin.common.convention.result.Result;
import com.lv.shortlink.admin.remote.dto.ShortLinkUpdateReqDTO;
import com.lv.shortlink.admin.remote.dto.req.*;
import com.lv.shortlink.admin.remote.dto.resp.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短链接中台远程调用服务
 */
public interface ShortLinkRemoteService {

    /**
     * 创建短链接
     *
     * @param requestParam
     * @return
     */
    default Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        String resultBodyStr = HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }

    /**
     * 分页查询短链接
     *
     * @param requestParam
     * @return
     */
    default Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gid", requestParam.getGid());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/page", requestMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }

    /**
     * 查询短链接分组内链接数量
     */
    default Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(List<String> requestParam) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("requestParam", requestParam);
        String resultStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/count", requestMap);
        System.out.println(resultStr);
        return JSON.parseObject(resultStr, new TypeReference<>() {
        });
    }

    /**
     * 修改短链接
     */
    default void updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/update", JSON.toJSONString(requestParam));
    }

    /**
     * 回收站保存
     *
     * @param requestParam
     */
    default void saveRecycleBin(RecycleBinSaveReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/recycle-bin/save", JSON.toJSONString(requestParam));
    }

    /**
     * 分页查询回收站短链接
     *
     * @param requestParam
     * @return
     */
    default Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecyclePageReqDTO requestParam) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gidList", requestParam.getGidList());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/recycle-bin/page", requestMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }

    /**
     * 短链接恢复
     *
     * @param requestParam
     */
    default void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/recycle-bin/recover", JSON.toJSONString(requestParam));
    }

    /**
     * 短链接彻底删除
     *
     * @param requestParam
     */
    default void removeRecycleBin(RecycleBinRemoveReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/recycle-bin/remove", JSON.toJSONString(requestParam));
    }

    /**
     * 访问单个短链接指定时间内监控数据
     */
    default Result<ShortLinkStatsRespDTO> oneShortLinkStats(ShortLinkStatsReqDTO requestParam) {
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("fullShortUrl",requestParam.getFullShortUrl());
        requestMap.put("gid",requestParam.getGid());
        requestMap.put("startDate",requestParam.getStartDate());
        requestMap.put("endDate",requestParam.getEndDate());
        String resultStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/stats", requestMap);
        return JSON.parseObject(resultStr, new TypeReference<Result<ShortLinkStatsRespDTO>>() {
        });
    }

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     */
    default Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam){
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("fullShortUrl",requestParam.getFullShortUrl());
        requestMap.put("gid",requestParam.getGid());
        requestMap.put("startDate",requestParam.getStartDate());
        requestMap.put("endDate",requestParam.getEndDate());
        requestMap.put("current",requestParam.getCurrent());
        requestMap.put("size",requestParam.getSize());
        String resultStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/stats/access-record", requestMap);
        return JSON.parseObject(resultStr, new TypeReference<>() {
        });
    }
}
