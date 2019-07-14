package com.lzp.concurrent.p1;

/**
 * @author lzp
 * @version v1.0 at 2019/5/30
 * @description:
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Task(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
    }

    static class Task implements Runnable{
        private Thread thread;

        public Task(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 终止");
        }
    }
}
