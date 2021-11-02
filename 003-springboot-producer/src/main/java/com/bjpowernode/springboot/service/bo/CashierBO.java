package com.bjpowernode.springboot.service.bo;

public class CashierBO {
    /**
     * 收银员ID
     */
    private Long cashierId;

    /**
     * 收银员姓名
     */
    private String cashierName;

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    @Override
    public String toString() {
        return "CashierBO{" + "cashierId=" + cashierId + ", cashierName='" + cashierName + '\'' + '}';
    }
}
