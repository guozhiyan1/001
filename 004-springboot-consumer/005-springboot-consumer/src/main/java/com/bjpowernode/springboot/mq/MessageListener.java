package com.bjpowernode.springboot.mq;

import com.alibaba.fastjson.JSON;
import com.bjpowernode.springboot.bo.*;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageListener implements MessageListenerConcurrently {
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        MessageExt ext=list.get(0);
        String mgs=new String(ext.getBody());
        PatientModifyNoticeBO notifyBO = JSON.parseObject(JSON.toJSONString(mgs), PatientModifyNoticeBO.class);
        System.out.println(mgs);
        System.out.println(notifyBO);
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
