package com.lzp.concurrent.p1;

/**
 * @author lzp
 * @version v1.0 at 2019/3/15
 */
public class ThreadSleepTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("开始进入睡眠");
                    Thread.sleep(10000);
                    System.out.println("结束睡眠");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        thread1.interrupt();

    }
}
