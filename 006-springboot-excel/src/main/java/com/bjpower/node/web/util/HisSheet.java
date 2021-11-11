/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bjpower.node.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;

/**
 * 导出Book 对象
 *
 * @author Damon
 * @version V1.0
 * @since 2017-11-28 09:54
 */
public class HisSheet {

    /**
     * 标题
     */
    private String title;

    /**
     * 行
     */
    private List<HisRow> rows;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HisRow> getRows() {
        return rows;
    }

    public void setRows(List<HisRow> rows) {
        this.rows = rows;
    }
    public void addRow(HisRow... row) {
        if(null == row || row.length == 0){
            return;
        }
        if(null == this.rows){
            this.rows = new ArrayList<>();
        }
        rows.addAll(Arrays.asList(row));
    }

    public static class HisRow {

        public static final Integer TYPE_NORMAL = 1;

        public static final Integer TYPE_TITLE = 2;

        public static final Integer TYPE_HEADER = 3;

        /**
         * 字段
         */
        private List<HisField> fields;

        /**
         * 是否头
         */
        private Integer type = TYPE_NORMAL;

        /**
         * 高度
         */
        private short height;

        public List<HisField> getFields() {
            return fields;
        }

        public void setFields(List<HisField> fields) {
            this.fields = fields;
        }

        public void addField(HisField... fieldList) {
            if(null == fieldList || fieldList.length == 0){
                return;
            }
            if(null == this.fields){
                this.fields = new ArrayList<>();
            }
            fields.addAll(Arrays.asList(fieldList));
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public short getHeight() {
            return height;
        }

        public void setHeight(short height) {
            this.height = height;
        }
    }

    public static class HisField {

        /**
         * 合并行数
         */
        private Integer colSpan = 1;

        /**
         * 合并列数
         */
        private Integer rowSpan = 1;

        /**
         * 单元格内容
         */
        private String value;

        /**
         * 是否区域单元格
         */
        private boolean region;

        /**
         * alignment
         */
        private boolean border = true;

        /**
         * 单元格类型
         *
         * @link org.apache.poi.hssf.usermodel.HSSFCell
         */
        private CellType cellType = CellType.STRING;

        public HisField() {

        }

        public HisField(String value) {
            this.value = value;
        }


        public static HisField instanceRegionField() {
            HisField hisField = new HisField();
            hisField.setRegion(true);
            return hisField;
        }

        public HisField(String value,boolean border) {
            this.value = value;
            this.border = border;
        }



        public Integer getColSpan() {
            return colSpan;
        }

        public void setColSpan(Integer colSpan) {
            this.colSpan = colSpan;
        }

        public Integer getRowSpan() {
            return rowSpan;
        }

        public void setRowSpan(Integer rowSpan) {
            this.rowSpan = rowSpan;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public CellType getCellType() {
            return cellType;
        }

        public void setCellType(CellType cellType) {
            this.cellType = cellType;
        }

        public boolean isRegion() {
            return region;
        }

        public void setRegion(boolean region) {
            this.region = region;
        }

        public boolean isBorder() {
            return border;
        }

        public void setBorder(boolean border) {
            this.border = border;
        }
    }

}

