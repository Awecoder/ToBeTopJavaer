package com.lzp.easycoding.p1;

/**
 * @author lzp
 * @version v1.0 at 2019/7/11
 * @description:
 */
public class ParamPassing {
    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");

    public static void main(String[] args) {
        // 方法调用1
        method(intStatic);
        System.out.println(intStatic);
        // 方法调用2
        method();
        System.out.println(intStatic);
        // 方法调用3
        method(stringStatic);
        System.out.println(stringStatic);
        // 方法调用4
        method(stringBuilderStatic, stringBuilderStatic);
        System.out.println(stringBuilderStatic);
    }

    // 方法1
    public static void method(int intStatic) {
        intStatic = 777;
    }

    // 方法2
    public static void method() {
        intStatic = 888;
    }

    // 方法3
    public static void method(String stringStatic) {
        stringStatic = "new string";
    }

    // 方法4
    public static void method(StringBuilder stringBuilderStatic1, StringBuilder stringBuilderStatic2) {
        stringBuilderStatic1.append(".method.first-");
        stringBuilderStatic2.append(".method.second-");

        // 引用重新赋值
        stringBuilderStatic1 = new StringBuilder("new stringBuilder");
        stringBuilderStatic1.append("new method's append");
    }
}
