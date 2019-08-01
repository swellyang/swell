package com.swell.code.business.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {

    public static void main(String[] args) {
        int corePoolSize = 10;//正常线程池大小
        int maximumPoolSize = 20;//最大线程池大小，当线程池达到正常大小并且等待队列已经满的时候，会自动增加线程到最大线程数量
        long keepAliveTime = 500;
        int queueSize = 200;//等待队列大小，可以根据该值大小做预警功能
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(queueSize), new ThreadPoolExecutor.AbortPolicy());

        int putTaskCount = 220;//准备执行的任务数
        for (int i = 0; i < putTaskCount; i++) {
            MyTask task = new MyTask(i);
            executor.execute(task);
        }

        executor.shutdown();

        //监控线程池状态
        while (putTaskCount > executor.getCompletedTaskCount()) {
            System.out.println(".");
            System.out.println("------------------------------------------------------");
            System.out.println("总线程数 : " + executor.getTaskCount());
            System.out.println("活动线程数 : " + executor.getActiveCount());
            System.out.println("排队线程数 : " + executor.getQueue().size());
            System.out.println("完成线程数 : " + executor.getCompletedTaskCount());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}

