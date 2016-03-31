package com.model.proxy;

/**
 * Created by shixing on 2016/3/31.
 */
public class RealSubject implements Subject {
    public void operate() {
        System.out.println("real subject operate started......");
    }
}
