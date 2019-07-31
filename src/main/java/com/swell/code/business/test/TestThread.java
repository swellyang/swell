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
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.addMoney(10, this.threadName);
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        TestThread tt = new TestThread(account, "User1");
        Thread thread1 = new Thread(tt);
        Thread thread2 = new Thread(tt);
        Thread thread3 = new Thread(tt);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
