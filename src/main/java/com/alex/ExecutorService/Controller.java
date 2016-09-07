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
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Type Controller.java
 * @Desc 
 * @author alex
 * @date 2016年9月3日 下午12:25:39
 * @version 
 */
public class Controller {
    
    ExecutorService exeService = null;
    FsGetVehByXlhThread vehFsGetVehThread = null;
    BlockingQueue<VehPass> vehPassQueue = null;
    
    
    
    public static void main(String[] args){
        new Controller().runCurrent();
        
    }
    
    private void runCurrent(){
        exeService=Executors.newCachedThreadPool();
        vehPassQueue=new ArrayBlockingQueue<VehPass>(10000);
        FsGetVehByXlhThread vehFsGetVehThread=new FsGetVehByXlhThread(vehPassQueue);
        vehFsGetVehThread.start();
        System.out.println(" begin to get VehData . ");
        for(int i=0;i<50;i++){
            FsInsertVehThread thread=new FsInsertVehThread("threadNUM:"+i,vehPassQueue);       
            exeService.execute(thread);
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