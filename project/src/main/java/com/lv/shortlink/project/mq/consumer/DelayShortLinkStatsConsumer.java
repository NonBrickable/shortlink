package com.lv.shortlink.project.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.lv.shortlink.project.common.constant.RocketMQConstant;
import com.lv.shortlink.project.dto.biz.ShortLinkStatsRecordDTO;
import com.lv.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 延迟记录短链接统计组件
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RocketMQMessageListener(
        topic = RocketMQConstant.STATUS_SAVE_DELAY_TOPIC,
        selectorExpression = RocketMQConstant.STATUS_SELECTOR_EXPRESSION,
        consumerGroup = RocketMQConstant.STATUS_DELAY_COMSUMER_GROUP
)
public class DelayShortLinkStatsConsumer implements RocketMQListener<Map<String,String>> {
    private final ShortLinkService shortLinkService;

    @Override
    public void onMessage(Map<String, String> producerMap) {
        shortLinkService.shortLinkStats(
                producerMap.get("fullShortUrl"),
                producerMap.get("gid"),
                JSON.parseObject(producerMap.get("statsRecord"), ShortLinkStatsRecordDTO.class));
    }
}
