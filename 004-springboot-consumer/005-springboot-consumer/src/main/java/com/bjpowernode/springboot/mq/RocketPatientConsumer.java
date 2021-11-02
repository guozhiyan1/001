/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bjpowernode.springboot.mq;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * 姓名、手机号变更，变更clinicvisit数据(候诊中、就诊中)
 * @author qinhy
 * @version V1.0
 * @since 2018-10-17 17:29
 */
@Configuration
public class RocketPatientConsumer {


    @Value("${rocketmq.patient.nameMobile.topic}")
    private String topic2;

    @Value("${rocketmq.patient.nameMobile.nameMobileTag}")
    private String tag2;
    @Value("${guahao.rocket.consumer-group}")
    private String group2;
    @Value("${guahao.rocket.name-server}")
    private String nameServer;
    @Resource
    private MessageListener messageListener;

    public DefaultMQPushConsumer ConsumeMessage() throws MQClientException {
        DefaultMQPushConsumer consumer=new DefaultMQPushConsumer(group2);
        consumer.setNamesrvAddr(nameServer);
        consumer.setVipChannelEnabled(false);

        consumer.registerMessageListener(messageListener);
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.subscribe(topic2,"test");
        consumer.start();
        return consumer;
    }

    public static void main(String[] args) {

         String topic2 = "his-basic-service-namemobile";
         String tag2 = "nameMobile-gzy";
         String group2 = "his-bill-consumer-group";
         String nameServer = "192.168.99.88:9876;192.168.99.74:9876";
        DefaultMQPushConsumer consumer=new DefaultMQPushConsumer(group2);
        consumer.setNamesrvAddr(nameServer);
        consumer.setVipChannelEnabled(false);
        MessageListener messageListener = new MessageListener();
        consumer.registerMessageListener(messageListener);
        consumer.setMessageModel(MessageModel.BROADCASTING);

        consumer.
    }
}
