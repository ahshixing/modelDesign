package com.model.coreJava;

/**
 * Created by shixing on 2016/4/26.
 */
public class MapDemo {

    /**
     *  LinkedHashMap保存了记录的插入顺序，先插入的先遍历到
     *  TreeMap默认是按升序排，也可以指定排序的比较器。遍历的时候按升序遍历。
     *  例如 a是LinkedHashMap，b是TreeMap。
     *      a.put("2","ab");
     *      a.put("1","bc");
     *      a.put("1","bc");
     *      b.put("2","ab");
     *      b.put("1","bc");
     *  那么遍历a的时候，先遍历到key是2的，因为2先放进去。
     *  遍历b的时候，先遍历到“1”，因为按顺序是先1后2
     *  它们底层的原理不一样，LinkedHashMap是用链表实现的，而TreeMap是用二叉树是实现的！
     */
}

