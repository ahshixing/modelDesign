package com.model.decorator;

/**
 * Created by shixing on 2016/4/27.
 */
public class 画眉 extends 化妆 {
    private 女人 女人;

    public 画眉(女人 女人) {
        super();
        this.女人 = 女人;
    }

    @Override
    public void 打扮() {
        System.out.println("画眉了，漂亮了一些。");
        女人.打扮();
    }
}
