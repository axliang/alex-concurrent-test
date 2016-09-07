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

import org.junit.Test;

/**
 * @Type TestLock.java
 * @Desc 
 * @author alex
 * @date 2016年9月7日 上午10:31:58
 * @version 
 */
public class TestLock {

    @Test 
    public void test() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }, "child thread -1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);

    }

    public static void main(String[] args) throws Exception {
        new TestLock().test();
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
