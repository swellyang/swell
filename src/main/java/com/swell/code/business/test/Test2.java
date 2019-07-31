package com.swell.code.business.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {

    public static void main(String[] args) {
        int corePoolSize = 100;//正常线程池大小
        int maximumPoolSize = 200;//最大线程池大小，当线程池达到正常大小并且等待队列已经满的时候，会自动增加线程到最大线程数量
        long keepAliveTime = 200;
        int queueSize = 10;//等待队列大小
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(queueSize), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 210; i++) {
            MyTask task = new MyTask(i);
            executor.execute(task);
            String s = "[poolSize:%s]\t[queueSize:%s]\t[completedTaskCount:%s]";
            String ss = String.format(s, executor.getPoolSize(), executor.getQueue().size(), executor.getCompletedTaskCount());
            System.out.println(ss);
        }

        executor.shutdown();
    }

}

