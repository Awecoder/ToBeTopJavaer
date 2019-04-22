package com.lzp.think;

/**
 * @author lzp
 * @version v1.0 at 2019/4/8
 */
public class ClassInitial {
    public static void main(String[] args) {
        Class c = Initable.class;
        System.out.println(Initable.staticFinal);
    }
}

class Initable{
    static final int staticFinal = 47;
    static {
        System.out.println("initial");
    }
}
