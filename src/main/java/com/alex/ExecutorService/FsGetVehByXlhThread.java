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

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * @Type FsGetVehByXlhThread.java
 * @Desc 
 * @author alex
 * @date 2016年9月3日 下午12:55:18
 * @version 
 */
public class FsGetVehByXlhThread extends Thread{


    protected BlockingQueue<VehPass> vehPassQueue;//队列1
    
    public  FsGetVehByXlhThread( BlockingQueue<VehPass> vehPassQueue ){
        super();
        this.vehPassQueue = vehPassQueue;
        super.setName("getData thread:0");
    }
    
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        long count =0l;
        while(true){
            
            ArrayList<VehPass>  vehPasses = this.getBathVeh(count++);
            for(VehPass  vehpass:vehPasses){
                try {
                    vehPassQueue.put(vehpass);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    private ArrayList<VehPass>  getBathVeh(long count){
        ArrayList<VehPass>  vehPasses= new  ArrayList<VehPass>();
        for(int i=0;i<10000;i++){
            VehPass  vehPass =new VehPass(count+"  "+i+" "," A123456  ","01",System.currentTimeMillis()+"");
            vehPasses.add(vehPass);
        }
        return  vehPasses;
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