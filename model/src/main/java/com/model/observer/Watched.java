package com.model.observer;

/**
 * Created by shixing on 2016/3/31.
 */
//抽象主题角色，watched：被观察
public interface Watched {
    void addWatcher(Watcher watcher);
    void removeWatcher(Watcher watcher);
    void notifyWatchers(String str);
}
