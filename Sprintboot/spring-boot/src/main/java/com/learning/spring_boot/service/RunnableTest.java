package com.learning.spring_boot.service;

public class RunnableTest implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable interface");
    }
}
