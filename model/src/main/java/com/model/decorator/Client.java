package com.model.decorator;

/**
 * Created by shixing on 2016/4/27.
 */
public class Client {
    public static void main(String[] args) {
        女人 女1 = new 程序媛();
        new 画眉(new 刷睫毛(new 涂口红(女1))).打扮();
    }
}
