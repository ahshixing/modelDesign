package com.model.proxy;

/**
 * Created by shixing on 2016/3/31.
 */
public class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    public void operate() {
        System.out.println("before operate......");
        subject.operate();
        System.out.println("after operate......");
    }
}
