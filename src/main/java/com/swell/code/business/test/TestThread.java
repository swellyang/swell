package com.swell.code.business.test;

public class TestThread implements Runnable {

    private Account account;
    private String threadName;

    public TestThread(Account account, String threadName) {
        this.account = account;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        for (int i = 0; i < 7; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.addMoney(10, this.threadName);
        }
    }
}
