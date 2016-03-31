package com.model.observer;

/**
 * Created by shixing on 2016/3/31.
 */
public class ConcreteWatcher implements Watcher {
    public void update(String str) {
        System.out.println(str);
    }
}
