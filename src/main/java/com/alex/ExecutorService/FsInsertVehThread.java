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

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * @Type FsInsertVehThread.java
 * @Desc 
 * @author alex
 * @date 2016年9月3日 下午12:55:55
 * @version 
 */
public class FsInsertVehThread extends Thread{
    
    BlockingQueue<VehPass> vehPassQueue;
    String threadNum;
    long logNum=10l;
    long logCount=0l;
    
    public FsInsertVehThread( String threadNum,BlockingQueue<VehPass> vehPassQueue){
        this.vehPassQueue =vehPassQueue;
        this.threadNum=threadNum;
        super.setName("consume "+threadNum+"");
    }
    
    
    @Override
    public void run(){
        
        while(true){
            insertVeh();
        }
    }
    
    
    private void insertVeh() {

        try {
            VehPass vehPass = vehPassQueue.take();
            String uuid = "";
//            for (int i = 0; i < 1000; i++) {
//                uuid = UUID.randomUUID().toString();
//            }
            vehPass.setRowkey(uuid);
//            if((logCount++)%logNum == 0){
//                System.out.println(threadNum+"   "+vehPass.toString());
//            }
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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