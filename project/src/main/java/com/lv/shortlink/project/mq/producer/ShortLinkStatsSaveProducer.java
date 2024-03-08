package com.lv.shortlink.project.mq.producer;

import com.lv.shortlink.project.common.constant.RocketMQConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

/**
 * 短链接监控状态保存消息队列生产者
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ShortLinkStatsSaveProducer {
    private final RocketMQTemplate rocketMQTemplate;

    public void asyncSendMsg(Message msg){
        rocketMQTemplate.asyncSend(RocketMQConstant.STATUS_SAVE_TOPIC, msg,new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("发送成功");
            }
            @Override
            public void onException(Throwable throwable) {
                log.error("消息发送失败");
            }
        });
    }
}
