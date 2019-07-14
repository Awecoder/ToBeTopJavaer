package com.lzp.easycoding.p1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzp
 * @version v1.0 at 2019/4/29
 * @description:
 */
public class Test {


    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1));
        list.add(new Student(2));
        list.add(new Student(3));
        Object[] copy = list.toArray();
        ((Student)copy[0]).value = 0;

        System.out.println(list.get(0).value);
        ArrayList list2 = new ArrayList();

    }
}

class Student{
    int value;

    public Student(int value) {
        this.value = value;
    }
}