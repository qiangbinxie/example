package com.xqb.example.java8;

import java.util.ArrayList;
import java.util.List;

public class ReferenceTest {

    public static void main(String[] args) {
        ReferenceTest referenceTest =new ReferenceTest();

        List<String> names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
        names.forEach(ReferenceTest::test);
        //only accept static method
//        names.forEach(referenceTest::test);
    }

    static int i = 1;
    public static void test(String s) {
        System.out.println("item(" + (i++) + "):" + s);
    }

//    int count = 1;
//    public void test2(String s){
//        System.out.println("item(" + (count++) + "):" + s);
//    }
}
