package com.bjpower.node.web;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/icdMed")
public class IcdMedicareController {
    @Autowired
    private IcdMedicareManager icdMedicareManager;
    @RequestMapping(value = "/batchExportIcd", method = { RequestMethod.GET})
    public String  batchExportIcd(HttpServletResponse response){
        HSSFWorkbook book = icdMedicareManager.exportNoCountryCode();
        response.setContentType("application/x-download");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=download.xls");
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            book.write(os);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("batchExportIcd error");
        }
        return null;
    }
}
