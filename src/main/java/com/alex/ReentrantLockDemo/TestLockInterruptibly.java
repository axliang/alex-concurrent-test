/*
 * Project: alex-concurrent-test
 * 
 * File Created at 2016年9月7日
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

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Type TestLockInterruptibly.java
 * @Desc 
 * @author alex
 * @date 2016年9月7日 上午10:51:51
 * @version 
 */
public class TestLockInterruptibly {

    // @Test 
    public void test3() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("before lock.lockInterruptibly;");
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        }, "child thread -1");
        t1.start();
        System.out.println("t1.start();");
        Thread.sleep(1000);
        System.out.println("before t1.interrupt();");
        t1.interrupt();
        System.out.println("after t1.interrupt();");
        Thread.sleep(1000000);
    }

    public static void main(String[] args) throws Exception {
        new TestLockInterruptibly().test3();
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年9月7日 alex creat
 */
