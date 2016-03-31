package com.model.proxy;

/**
 * Created by shixing on 2016/3/31.
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.operate();
    }
}
