package com.lzp.coderead;

/**
 * @author lzp
 * @version v1.0 at 2019/4/23
 * @description:
 */
public class StringIntern {
    public static void main(String[] args) {
//        String a = "abc";
//        String b = "a" + "bc";
//        // 对于b，JVM进行编译时优化
//        System.out.println(a == b);
//        // 如果字符串叠加时出现了变量，JVM无法合并。
//        String var1 = "a";
//        String c = var1 + "bc";
//        System.out.println(a == c);
//        // final修饰的变量，编译器视为不可变，可以编译时优化
//        final String var2 = "a";
//        String d = var2 + "bc";
//        System.out.println(a == d);

        String a = new String("ab");
        String b = new String("ab");
        System.out.println(a == b);
        System.out.println(a.intern() == b.intern());
        String c = "ab";
        System.out.println(a.intern() == c);
        String d = "b";
        String e = "a" + d;
        System.out.println(a.intern() == d);
        System.out.println("------------");
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        // 内容相同
        System.out.println(str5.equals(str3)); // true
        // 比较引用的地址是否相同
        // str5采用new String方式定义的，所以地址引用一定不相等。
        System.out.println(str5 == str3); // false
        // str5调intern，会检查字符串池中是否含有该字符串。
        // 由于之前定义的str3已经进入字符串池中，所以会得到相同的引用。
        System.out.println(str5.intern() == str3); // true
        System.out.println(str5.intern() == str4); // false
    }
}
