package com.bjpower.node.web;


import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author fangwq1
 * @version V1.0
 * @className IcdMedicareManager
 * @description icd医保Manager层
 * @since 2021/8/27 16:31
 */
public interface IcdMedicareManager {

    /**
     * 批量导出
     * @return
     */
    HSSFWorkbook exportNoCountryCode();

}