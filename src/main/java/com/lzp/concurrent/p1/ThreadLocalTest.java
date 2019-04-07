package com.lzp.concurrent.p1;

/**
 * @author lzp
 * @version v1.0 at 2019/3/21
 */
public class ThreadLocalTest {
    // 初始化ThreadLocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str) {
        // 打印当前线程本地内存中的变量值
        System.out.println(str + ": " + localVariable.get());
        // 清除当前线程本地内存中的变量
        localVariable.remove();
    }

    public static void main(String[] args) {
        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 设置线程A中的本地变量的值
                localVariable.set("threadA localVariable");
                print("threadA");
                // 获取线程A中的本地变量的值
                System.out.println("threadA remove after: " + localVariable.get());
            }
        });
//        // 创建线程B
//        Thread threadB = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                localVariable.set("threadB localVariable");
//                print("threadB");
//                System.out.println("threadB remove after: " + localVariable.get());
//            }
//        });

        // 启动线程
        threadA.start();
//        threadB.start();
    }
}
