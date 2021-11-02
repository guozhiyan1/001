package com.bjpowernode.springboot.config.dao;


import java.util.List;

import com.bjpowernode.springboot.service.bo.CashierBO;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.spring.annotation.MapperScan;


@Component
public interface BillPaymentMapper {

    /**
     * 获取收银员列表
     *
     */
    List<CashierBO> getCashierList(@Param("hospId") Integer hospId);

}