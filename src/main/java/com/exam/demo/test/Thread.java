package com.exam.demo.test;

/**
 * Created by syg on 2018-11-11
 */
class Threads extends Thread {

    public Threads() {
        System.out.println("构造方法打印=========="+Thread.currentThread().getName());
    }

    public void run(){
        System.out.println("Run方法打印=========="+Thread.currentThread().getName());
    }
}
