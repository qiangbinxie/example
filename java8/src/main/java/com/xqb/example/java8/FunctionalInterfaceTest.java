package com.xqb.example.java8;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Predicate;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        FunctionalInterfaceTest functionalInterfaceTest = new FunctionalInterfaceTest();

        //provided functional interface Predicate
        Predicate<String> predicate = s -> s.length() > 0;
        System.out.println(predicate.test("fff"));

        Predicate<Integer> predicate2 = s -> s > 0;
        System.out.println(predicate2.test(-5));

        //provided functional interface Comparator
        Apple a1 = new Apple(60);
        Apple a2 = new Apple(20);
        Comparator<Apple> compareWeight = (s1, s2) -> s1.getWeight().compareTo(s2.getWeight());
        System.out.println(compareWeight.compare(a1,a2));
        functionalInterfaceTest.testCompare(a1,a2,functionalInterfaceTest::customCompare);


        //self-defined functional interface
        Converter<String, Double> string2Duble = s -> Double.valueOf(s);
        System.out.println(string2Duble.convert("5"));

        Converter<Date, String> date2String = s -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(s);
        System.out.println(date2String.convert(new Date()));

        //self-defined functional interface and pass as a parameter
        FT ft1 = s -> System.out.println("this is the input: " + s);
        functionalInterfaceTest.test("data", ft1);
        //given the method signature is consistent to the functional interface, it can be passed as well
        functionalInterfaceTest.test("data", functionalInterfaceTest::customFT);

    }

    public void test(String s, FT ft) {
        System.out.println(s);
        ft.run(s);
    }

    public void testCompare(Apple a1,Apple a2, Comparator comparator){
        System.out.println("customized compare result:" + comparator.compare(a1,a2));
    }

    public void customFT(String s) {
        System.out.println(new Date() + ":" + s);
    }

    public int customCompare(Object o1, Object o2) {
        Apple a1 = (Apple)o1;
        Apple a2 = (Apple)o2;
        if ((a1).getWeight() > a2.getWeight()) return 9999;
        if (a1.getWeight() < a2.getWeight()) return -9999;
        else return 0;
    }
}


@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

@FunctionalInterface
interface FT {
    void run(String s);
}

@Data
class Apple {
    public Apple(Integer weight) {
        this.weight = weight;
    }

    Integer weight;
}
