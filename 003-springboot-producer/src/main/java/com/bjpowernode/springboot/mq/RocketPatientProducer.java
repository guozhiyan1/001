package com.bjpowernode.springboot.mq;

import com.alibaba.fastjson.JSON;
import com.bjpowernode.springboot.service.bo.PatientModifyNoticeBO;

import com.greenline.rocketmq.util.HessianUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 修改姓名、手机号
 * @author qinhy
 * @version V1.0
 * @since 2018-10-18 16:54
 */
@Component
public class RocketPatientProducer {

    private static final Logger LOG= LoggerFactory.getLogger(RocketPatientProducer.class);

    @Value("${rocketmq.patient.nameMobile.topic}")
    private String topic;

    @Value("${rocketmq.patient.nameMobile.nameMobileTag}")
    private String tag;
    @Value("${guahao.rocket.name-server}")
    private String nameServer;
    @Value("${guahao.rocket.producer-group}")
    private String group;


    public String getTopic() {
        return topic;
    }

    public String getTag() {
        return tag;
    }


    public Object notifyNameMobile(PatientModifyNoticeBO patientBO) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        DefaultMQProducer producer= new DefaultMQProducer(group);
        String msg = JSON.toJSONString(patientBO);
//        LOG.info("shishi姓名、手机号，入参：{}",msg.getBytes());
        Message message=new Message(topic,tag,"", HessianUtils.encode(msg));
        producer.setNamesrvAddr(nameServer);
        producer.setVipChannelEnabled(false);
        producer.shutdown();
        producer.start();
        producer.sendOneway(message);
        return producer;
    }

}
