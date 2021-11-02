package com.bjpowernode.springboot;

import com.bjpowernode.springboot.mq.RocketPatientProducer;
import com.bjpowernode.springboot.service.bo.PatientModifyNoticeBO;
import com.bjpowernode.springboot.service.PaymentManager;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(method = RequestMethod.GET, value = "/bill")
public class BillPaymentController {
    @Autowired
    private PaymentManager paymentManager;
    @Autowired
    private RocketPatientProducer rocketPatientProducer;

    @RequestMapping(method = RequestMethod.GET,value="/payment/cashier")
    public @ResponseBody Object listCashier(@RequestParam("orgId") Integer orgId,
                                            @RequestParam("hospId") Integer hospId){

        return paymentManager.getCashierList(orgId, hospId);
    }
    @RequestMapping(method = RequestMethod.GET,value="/send")
    public @ResponseBody Object send1(@RequestBody PatientModifyNoticeBO patientBO) throws InterruptedException, MQBrokerException, RemotingException, MQClientException {
        DefaultMQProducer producer= (DefaultMQProducer) rocketPatientProducer.notifyNameMobile(patientBO);

        return "发送成功";
    }
}
