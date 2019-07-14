package com.lzp.concurrent.p1;

/**
 * @author lzp
 * @version v1.0 at 2019/6/10
 * @description:
 */
public class IsInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });

        thread.start();

        thread.sleep(1000);

        thread.interrupt();
    }
}
