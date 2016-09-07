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
package com.alex.ReentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Type Controller.java
 * @Desc 
 * @author alex
 * @date 2016年9月3日 下午6:29:19
 * @version 
 */
public class Controller {

    //默认false 不公平锁，true 公平锁
    private ReentrantLock lock = new ReentrantLock(true);
//    private ReentrantLock lock = new ReentrantLock(true);

    public boolean getLock(String ThreadName) {

        if (lock.tryLock()) {
//          if (lock.lockInterruptibly()) {
            try {
                long speepLong = 2000l;
                System.out.println(
                        ThreadName + "  get lock ,keep the lock for " + speepLong + " millseconds");
                Thread.sleep(speepLong);
                System.out.println(ThreadName + " unlocked  ~");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            return true;
        } else {
            return false;
        }

    }
    

    public static void main(String[] args){
        Controller  controller = new Controller();
//        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0;i<20;i++){
//            es.execute(new ThreadRun("thread: "+i,controller));
            new ThreadRun("thread: "+i,controller).start();
        }
    }

}

class ThreadRun extends Thread {

    Controller controller;
    String ThreadName;
    long speepLong = 1000l;
    long count = 0l;

    public ThreadRun(String ThreadName, Controller controller) {
        this.controller = controller;
        this.ThreadName = ThreadName;

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (!controller.getLock(ThreadName)) {
            try {
//                System.out.println(ThreadName + "  try lock time:" + ++count + " ,wait for "
//                        + speepLong + " millseconds to retry");
                Thread.sleep(speepLong);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
