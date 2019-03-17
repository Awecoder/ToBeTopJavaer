package com.lzp.easycoding.p1;

/**
 * 补码、原码、反码
 *
 * @author lzp
 * @version v1.0 at 2019/3/17
 */
public class ZeroOne {
    public static void main(String[] args) {
        System.out.println("42: " + Integer.toBinaryString(42));
        System.out.println("-42: " + Integer.toBinaryString(-42));
        System.out.println("42 << 1: " + Integer.toBinaryString(42 << 1));
        System.out.println("42 << 33: " + Integer.toBinaryString(42 << 1));
        System.out.println("42 >> 1: " + Integer.toBinaryString(42 >> 1));
        System.out.println("42 >> 33: " + Integer.toBinaryString(42 >> 1));
        System.out.println("-42 << 1: " + Integer.toBinaryString(-42 << 1));
        System.out.println("-42 << 33: " + Integer.toBinaryString(-42 << 1));
        System.out.println("-42 >> 1: " + Integer.toBinaryString(-42 >> 1));
        System.out.println("-42 >> 33: " + Integer.toBinaryString(-42 >> 1));

        System.out.println();
    }
}
