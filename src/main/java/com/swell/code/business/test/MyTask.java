package com.swell.code.business.test;

public class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
//        System.out.println("正在执行 task" + taskNum);
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("结束执行 task" + taskNum);
    }
}
