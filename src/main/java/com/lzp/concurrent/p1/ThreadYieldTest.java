package com.lzp.concurrent.p1;

/**
 * @author lzp
 * @version v1.0 at 2019/3/19
 */
public class ThreadYieldTest implements Runnable {
    public ThreadYieldTest() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            if (i % 5 == 0) {
                System.out.println("当前线程：" + Thread.currentThread() + "让出CPU...");
                Thread.yield();
            }

        }
        System.out.println("当前线程：" + Thread.currentThread() + "执行结束...");
    }

    public static void main(String[] args) {
        new ThreadYieldTest();
        new ThreadYieldTest();
        new ThreadYieldTest();
    }
}
