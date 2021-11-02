package com.bjpowernode.springboot.service;

import com.bjpowernode.springboot.service.bo.CashierBO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentManager {

    List<CashierBO> getCashierList(Integer orgId, Integer hospId);
}
