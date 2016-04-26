package com.model.coreJava;

/**
 * Created by shixing on 2016/4/26.
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("Thread1");
        Thread2 thread2 = new Thread2("Thread2", thread1);
        thread2.start();
    }

    static class Thread1 extends Thread {
        public Thread1(String threadName) {
            super(threadName);
        }
        public void run() {
            System.out.println(getName() + " is running");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread2 extends Thread {
        private Thread1 thread1;
        public Thread2(String threadName, Thread1 thread1) {
            super(threadName);
            this.thread1 = thread1;
        }
        public void run() {
            System.out.println(getName() + " is running");
            try {
                sleep(2000);
                thread1.start();
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 is over");
        }
    }
}
