package com.swell.code.business.test;

public class Test {

    public static void main(String[] args) {

        Account account = new Account();

        TestThread tt = new TestThread(account,"aa");

        Thread thread1 = new Thread(tt);
        Thread thread2 = new Thread(tt);
        Thread thread3 = new Thread(tt);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
