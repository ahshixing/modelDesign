package com.model.templateMethod;

/**
 * Created by shixing on 2016/3/31.
 */

/**
 * 具体模板角色类，实现了父类所声明的基本方法，
 * abstractMethod()方法所代表的就是强制子类实现的剩余逻辑
 * 而hookMethod()方法是可选择实现的逻辑，不是必须实现的
 * 模板模式的关键是：子类可以置换掉父类的可变部分，但是子类却不可以改变模板方法所代表的顶级逻辑。
 */
public class ConcreteTemplate extends AbstractTemplate {
    //基本方法的实现
    @Override
    protected void abstractMethod() {
        //业务相关的代码
    }
    //重写父类的方法
    @Override
    public void hookMethod() {
        //业务相关的代码
    }
}
