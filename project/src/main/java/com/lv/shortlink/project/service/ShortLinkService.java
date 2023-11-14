package com.lv.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.shortlink.project.dao.entity.ShortLinkDO;
import com.lv.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.lv.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.lv.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.util.List;

/**
 * 短链接接口层
 */
public interface ShortLinkService extends IService<ShortLinkDO> {
    /**
     * 创建短链接
     * @param requestParam
     * @return
     */
    ShortLinkCreateRespDTO createShorLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 修改短链接
     * @param requestParam
     */
    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    /**
     * 分页查询短链接
     * @param requestParam
     * @return
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 查询短链接分组内数量
     * @param requestParam
     * @return
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);

    /**
     * 短链接跳转
     * @param shortUri 短链接后缀
     * @param request 请求
     * @param response 响应
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);
}
