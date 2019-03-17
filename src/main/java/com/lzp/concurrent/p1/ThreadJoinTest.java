package com.lzp.concurrent.p1;

/**
 * @author lzp
 * @version v1.0 at 2019/3/12
 */
public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1结束");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2结束");
            }
        });
        thread1.start();
        thread2.start();
        System.out.println("等待子线程结束");
        thread1.join();
        thread2.join();
        System.out.println("所有子线程结束");
    }
}
