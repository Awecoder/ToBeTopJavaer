package com.lzp.concurrent.p1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程唯一标识符生成器
 */
public class ThreadId {
    // 下一个要被分配的线程id
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // 线程局部变量
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    // 返回当前线程唯一的id
    public static int get() {
        return threadId.get();
    }
}
