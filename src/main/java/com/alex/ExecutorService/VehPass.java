/*
 * Project: alex-concurrent-test
 * 
 * File Created at 2016年9月3日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.alex.ExecutorService;

/**
 * @Type getVehPassServer.java
 * @Desc 
 * @author alex
 * @date 2016年9月3日 下午12:26:31
 * @version 
 */
public class VehPass {
    private String xlh;
    private String hphm;
    private String hpzl;
    private String gcsj;
    private String rowkey;
    
    
    public String getRowkey() {
        return rowkey;
    }
    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }
    public String getXlh() {
        return xlh;
    }
    public void setXlh(String xlh) {
        this.xlh = xlh;
    }
    public String getHphm() {
        return hphm;
    }
    public void setHphm(String hphm) {
        this.hphm = hphm;
    }
    public String getHpzl() {
        return hpzl;
    }
    public void setHpzl(String hpzl) {
        this.hpzl = hpzl;
    }
    public String getGcsj() {
        return gcsj;
    }
    public void setGcsj(String gcsj) {
        this.gcsj = gcsj;
    }
    @Override
    public String toString() {
        return "VehPass [xlh=" + xlh + ", hphm=" + hphm + ", hpzl=" + hpzl + ", gcsj=" + gcsj
                + ", rowkey=" + rowkey + "]";
    }
    public VehPass(String xlh, String hphm, String hpzl, String gcsj) {
        super();
        this.xlh = xlh;
        this.hphm = hphm;
        this.hpzl = hpzl;
        this.gcsj = gcsj;
    }
    
    
    

    
    
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年9月3日 alex creat
 */