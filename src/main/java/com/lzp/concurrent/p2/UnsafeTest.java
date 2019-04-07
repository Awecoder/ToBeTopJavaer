package com.lzp.concurrent.p2;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author lzp
 * @version v1.0 at 2019/3/28
 */
public class UnsafeTest {
    // 获取Unsafe实例
//    static final Unsafe unsafe = Unsafe.getUnsafe();
    static final Unsafe unsafe;
    static final long stateOffSet;

    private volatile long state = 0;

    static {
        try {
            // 使用反射获取到Unsafe成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            // 设置可存取
            field.setAccessible(true);

            // 获取变量值
            unsafe = (Unsafe) field.get(null);

            // 获取state在类中的偏移
            stateOffSet = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {

        UnsafeTest unsafeTest = new UnsafeTest();
        Boolean sucess = unsafe.compareAndSwapInt(unsafeTest, stateOffSet, 0, 1);
        System.out.println(sucess);
    }
}
