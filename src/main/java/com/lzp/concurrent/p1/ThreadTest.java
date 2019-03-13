package com.lzp.concurrent.p1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程的三种创建方式
 *
 * @author lzp
 * @version v1.0 at 2019/3/12
 */
public class ThreadTest {

    /**
     * 方式1：继承java.lang.Thread类，重写run方法
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a thread child thread!");
        }
    }

    /**
     * 方式2：实现Runnable接口的run方法
     */
    public static class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("I am a runnable child thread!");
        }
    }

    /**
     * 方式3：使用FutureTask方式--J.U.C
     */
    public static class CallableTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Hello Callable";
        }
    }

    public static void main(String[] args) {
        // 1
        MyThread thread = new MyThread();
        thread.start();

        // 2
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();

        // 3
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallableTask());
        // 启动线程
        new Thread(futureTask).start();
        try {
            // 等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
