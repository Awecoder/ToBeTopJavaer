package com.lzp.concurrent.p2.synchronize;

/**
 * 消失的请求数
 *
 * @author lzp
 * @version v1.0 at 2019/4/10
 */
public class DisappearRequest implements Runnable {
    static DisappearRequest instance = new DisappearRequest();
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join(); // 等待线程执行
        thread2.join();
        System.out.println(i);
    }
}
