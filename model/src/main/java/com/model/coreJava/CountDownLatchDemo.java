package com.model.coreJava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 *  CountDownLatch : 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行。
 *  CyclicBarrier  : N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。
 *  这样应该就清楚一点了，对于CountDownLatch来说，重点是那个“一个线程”, 是它在等待，而另外那N的线程在把“某个事情”做完之后可以继续等待，可以终止。
 *  而对于CyclicBarrier来说，重点是那N个线程，他们之间任何一个没有完成，所有的线程都必须等待。
 *  CountDownLatch 是计数器, 线程完成一个就记一个, 就像 报数一样, 只不过是递减的.
 *  而CyclicBarrier更像一个水闸, 线程执行就想水流, 在水闸处都会堵住, 等到水满(线程到齐)了, 才开始泄流.
 *  CyclicBarrier可以重复使用已经通过的障碍,而CountdownLatch不能重复使用
 */
public class CountDownLatchDemo {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);//两个工人的协作
        Worker worker1 = new Worker("zhang san", 5000, latch);
        Worker worker2 = new Worker("li si", 8000, latch);
        worker1.start();//
        worker2.start();//
        latch.await();//等待所有工人完成工作
        System.out.println("all work done at " + sdf.format(new Date()));
    }

    static class Worker extends Thread {
        String workerName;
        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        public void run() {
            System.out.println("Worker " + workerName + " do work begin at " + sdf.format(new Date()));
            doWork();//工作了
            System.out.println("Worker " + workerName + " do work complete at " + sdf.format(new Date()));
            latch.countDown();//工人完成工作，计数器减一
        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
