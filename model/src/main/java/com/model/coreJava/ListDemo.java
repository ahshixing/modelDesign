package com.model.coreJava;

import java.util.*;

/**
 * Created by shixing on 2016/4/26.
 */
public class ListDemo {
    public static final int N = 50000;

    public static List values;

    static {
        Integer vals[] = new Integer[N];
        Random r = new Random();
        for (int i = 0, currval = 0; i < N; i++) {
            vals[i] = currval;
            currval += r.nextInt(100) + 1;
        }
        values = Arrays.asList(vals);
    }

    /**
     * ArrayList的内部实现是基于基础的对象数组的，因此，它使用get方法访问列表中的任意一个元素时(random access)，
     * 它的速度要比LinkedList快。LinkedList中的get方法是按照顺序从列表的一端开始检查，直到另外一端。
     * 对LinkedList而言，访问列表中的某个指定元素没有更快的方法了。
     * 假设我们有一个很大的列表，它里面的元素已经排好序了，这个列表可能是ArrayList类型的也可能是LinkedList类型的，
     * 现在我们对这个列表来进行二分查找(binary search)，比较列表是ArrayList和LinkedList时的查询速度
     */
    static long binarySearchTimeList(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            int index = Collections.binarySearch(list, values.get(i));
            if (index != i)
                System.out.println("***错误***");
        }
        return System.currentTimeMillis() - start;
    }

    /**
     * 要对其进行大量的插入和删除操作，在这种情况下LinkedList就是一个较好的选择
     */
    static long addItemTimeList(List list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++)
            list.add(0, o);
        return System.currentTimeMillis() - start;
    }

    /**
     * 当操作是在一列数据的后面添加数据而不是在前面或中间,并且需要随机地访问其中的元素时,使用ArrayList会提供比较好的性能；
     * 当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中的元素时,就应该使用LinkedList了
     */
    public static void main(String args[]) {
        System.out.println("ArrayList消耗时间：" + binarySearchTimeList(new ArrayList(values)));
        System.out.println("LinkedList消耗时间：" + binarySearchTimeList(new LinkedList(values)));
        System.out.println("ArrayList耗时：" + addItemTimeList(new ArrayList()));
        System.out.println("LinkedList耗时：" + addItemTimeList(new LinkedList()));
    }
}
