package com.bjpowernode.springboot.serviceImpl;

import com.bjpowernode.springboot.config.dao.BillPaymentMapper;
import com.bjpowernode.springboot.service.PaymentManager;
import com.bjpowernode.springboot.service.bo.CashierBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentManagerImpl implements PaymentManager {
    @Autowired
    private BillPaymentMapper billPaymentMapper;
    @Override
    public List<CashierBO> getCashierList(Integer orgId, Integer hospId) {
        List<CashierBO> cashierPOList = billPaymentMapper.getCashierList(hospId);
        return cashierPOList;
    }
}
