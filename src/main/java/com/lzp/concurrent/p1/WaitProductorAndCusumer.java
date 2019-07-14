package com.lzp.concurrent.p1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用wait和notifyAll实现生产者与消费者
 *
 * @author lzp
 * @version v1.0 at 2019/3/13
 */
public class WaitProductorAndCusumer {
    private static final int MAX_SIZE = 2;

    /**
     * 生产者线程
     */
    public static class Producer implements Runnable {
        private Queue<Integer> queue;

        public Producer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            synchronized (queue) {
                while (queue.size() == MAX_SIZE) {
                    try {
                        // 挂起当前线程，释放共享变量上的锁
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 队列不满则生产元素,通知唤醒消费者线程
                queue.add((int) (Math.random() * 10));
                queue.notifyAll();
            }
        }
    }

    /**
     * 消费者线程
     */
    public static class Consumer implements Runnable {
        private Queue<Integer> queue;

        public Consumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        // 挂起当前线程，释放queue上的锁
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 消费元素，并通知唤醒生产者线程
                queue.remove();
                queue.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        for (int i = 0; i < 10; i++) {
            new Thread(consumer).start();
            new Thread(producer).start();
        }
    }
}
