package com.swell.code.platform.service.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void executeAsync1(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...... 异步任务1");
    }

    @Async
    public void executeAsync2(){
        System.out.println("...... 异步任务2");
    }
}
