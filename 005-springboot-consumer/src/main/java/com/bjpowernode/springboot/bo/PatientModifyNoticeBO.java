package com.bjpowernode.springboot.bo;/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */


import java.io.Serializable;

/**
 * @author qinhy
 * @version V1.0
 * @since 2018-10-17 17:38
 */
public class PatientModifyNoticeBO implements Serializable {

    private static final long serialVersionUID = 1130776544467284061L;

    private Long patientId;
    private String patientName;
    private String mobile;
    private String clinicCardNo;
    private Integer userModified;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getUserModified() {
        return userModified;
    }

    public void setUserModified(Integer userModified) {
        this.userModified = userModified;
    }

    public String getClinicCardNo() {
        return clinicCardNo;
    }

    public void setClinicCardNo(String clinicCardNo) {
        this.clinicCardNo = clinicCardNo;
    }
}
