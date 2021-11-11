package com.bjpower.node.web.impl;

import com.bjpower.node.web.IcdMedicareManager;
import com.bjpower.node.web.util.HisSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fangwq1
 * @version V1.0
 * @className IcdMedicareManagerImpl
 * @description icd医保Manager层实现类
 * @since 2021/8/27 16:32
 */
@Service
public class IcdMedicareManagerImpl implements IcdMedicareManager {
    private static final Logger LOG = LoggerFactory.getLogger(IcdMedicareManagerImpl.class);

    /**
     * 线程池
     */
    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(3,
            20,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(500),
            new ThreadPoolExecutor.AbortPolicy());



    /**
     * 下载导出空模板,返回一个工作簿
     * @return
     */
   public HSSFWorkbook exportNoCountryCode()
   {
       HisSheet hisSheet = new HisSheet();
       hisSheet.setTitle("中西医疾病诊断导入模版");//一个sheet

       List<HisSheet.HisRow> hisRows = new ArrayList<>();//大行
       List<HisSheet.HisField> fields = new ArrayList<>();//大单元格

       HisSheet.HisRow title = new HisSheet.HisRow();
       title.setType(HisSheet.HisRow.TYPE_TITLE);//标题的小行

       HisSheet.HisField hisField = new HisSheet.HisField("中西医疾病诊断导入模版");//小单元格
       hisField.setColSpan(8);
       fields.add(hisField);//大单元格增加小单元格
       title.setFields(fields);
       hisRows.add(title); //大行增加标题小行
       //第二行
       HisSheet.HisRow row = new HisSheet.HisRow();//小行
       row.setType(HisSheet.HisRow.TYPE_HEADER);//3
       fields = new ArrayList<>();//大单元格

       hisField = new HisSheet.HisField("科别类目名称");//小单元格
       fields.add(hisField);

       hisField = new HisSheet.HisField("专科系统分类目名称");
       fields.add(hisField);

       hisField = new HisSheet.HisField("国临版编码");
       fields.add(hisField);

       hisField = new HisSheet.HisField("国临版名称");
       fields.add(hisField);

       hisField = new HisSheet.HisField("医保版编码");
       fields.add(hisField);

       hisField = new HisSheet.HisField("医保版名称");
       fields.add(hisField);

       hisField = new HisSheet.HisField("类型(0:西医,1:中医证候分类，2：中医疾病分类)");
       fields.add(hisField);

       row.setFields(fields);
       hisRows.add(row);
       hisSheet.setRows(hisRows);
      /* for (IcdMedExcelImportVO vo : icdMedExcelImportVOs) {
           fields = new ArrayList<>();
           row = new HisSheet.HisRow();

           hisField = new HisSheet.HisField(vo.getMedicareDiagnoseName());
           fields.add(hisField);

           hisField = new HisSheet.HisField(vo.getCategoryName());
           fields.add(hisField);


           hisField = new HisSheet.HisField(vo.getSystemCategoryName());
           fields.add(hisField);

           hisField = new HisSheet.HisField(vo.getIcdCode());
           fields.add(hisField);

           hisField = new HisSheet.HisField(vo.getIcdName());
           fields.add(hisField);

           hisField = new HisSheet.HisField(vo.getMedicareCode());
           fields.add(hisField);

           hisField = new HisSheet.HisField(vo.getMedicareDiagnoseName());
           fields.add(hisField);

           row.setFields(fields);
           hisRows.add(row);
       }*/
     //  hisSheet.setRows(hisRows);
//       if (hisSheet.getRows() != null) {
//           return ExcelExportUtils.buildBook(hisSheet);
//       }
       return new HSSFWorkbook();
   }
}
