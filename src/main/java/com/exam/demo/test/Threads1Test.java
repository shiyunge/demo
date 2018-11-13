package com.exam.demo.test;

/**
 * Created by syg on ${Date}
 */
public class Threads1Test {

    public static void main(String[] args) {

        Threads1 threads1 = new Threads1();
        System.out.print("begain"+threads1.isAlive());
        threads1.start();
        System.out.print("begain"+threads1.isAlive());

    }

}
