package com.lv.shortlink.project.mq.producer;

import com.lv.shortlink.project.common.constant.RocketMQConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 延迟消费短链接统计发送者
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DelayShortLinkStatsProducer {
    private final RocketMQTemplate rocketMQTemplate;

    public void delaySend(Map<String, String> producerMap){
        SendCallback sendCallback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("消息发送失败");
            }
        };
        rocketMQTemplate.asyncSend(RocketMQConstant.STATUS_SAVE_DELAY_TOPIC, MessageBuilder.withPayload(producerMap).build(),sendCallback,2000L,2);
    }
}
