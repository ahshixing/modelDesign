package com.model.decorator;

/**
 * Created by shixing on 2016/4/27.
 */
public class 化妆 implements 女人 {
    private 女人 女人;

    @Override
    public void 打扮() {
        女人.打扮();
    }
}
