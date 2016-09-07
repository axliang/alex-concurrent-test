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
package com.alex.CallableFutureService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.alex.ExecutorService.VehPass;

/**
 * @Type Controller.java
 * @Desc 
 * @author alex
 * @date 2016年9月3日 下午4:18:10
 * @version 
 */
public class Controller {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        TaskVeh taskVeh = new TaskVeh();
        Future<Integer> result = executor.submit(task);
        
//        executor.shutdown();
        Future<List<VehPass>> vehPassesList = executor.submit(taskVeh);
//        executor.shutdown();
        
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }  catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + result.get());
            System.out.println("taskVeh运行结果" + vehPassesList.get().get(0).toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
   

}



class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        System.out.println("Task计算完成");
        return sum;
    }
    
}


class TaskVeh implements Callable<List<VehPass>> {
    @Override
    public List<VehPass> call() throws Exception {
        ArrayList<VehPass>  vehPasses= new  ArrayList<VehPass>();
        for(int i=0;i<10000;i++){
            VehPass  vehPass =new VehPass("  "+i+" "," A123456  ","01",System.currentTimeMillis()+"");
            vehPasses.add(vehPass);
        }
        System.out.println("TaskVeh计算完成");
        return vehPasses;
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
