package com.swell.code.business.test;

public class Account {
    private int money = 100;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int m, String name) {
        money += m;
        System.out.println(name + "---" + Thread.currentThread().getName() + ":" + money);
    }

}
