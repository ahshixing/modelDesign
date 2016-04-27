package com.model.decorator;

/**
 * Created by shixing on 2016/4/27.
 */
public class 刷睫毛 extends 化妆 {
    private 女人 女人;

    public 刷睫毛(女人 女人) {
        super();
        this.女人 = 女人;
    }

    public void 打扮() {
        System.out.println("刷睫毛了，更漂亮了一些。");
        女人.打扮();
    }
}
