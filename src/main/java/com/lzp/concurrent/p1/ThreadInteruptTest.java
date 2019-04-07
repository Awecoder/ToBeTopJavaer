package com.lzp.concurrent.p1;

/**
 * @author lzp
 * @version v1.0 at 2019/3/19
 */
public class ThreadInteruptTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        thread.start();

        // 中断子线程
        thread.interrupt();

        // interrupted()方法获取的是当前调用线程的中断标志，而主线程才是当前线程
        // 主线程没有被中断
        System.out.println(thread.interrupted()); // false
        System.out.println(Thread.interrupted()); // false
        // 中断主线程
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted()); // true 检测中断，清理中断标志
        System.out.println(Thread.interrupted()); // false

        // 检测子线程中断
        System.out.println(thread.isInterrupted()); // true
        System.out.println(thread.isInterrupted()); // true
        System.out.println(Thread.currentThread().isInterrupted()); // false 主线程没有被中断



        System.out.println();

    }
}
