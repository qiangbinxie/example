package com.xqb.example.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StreamTest3 {
    private static List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
    private static IntSummaryStatistics stats;

    @Before
    public void beforeStringTest() {
        System.out.println("列表: " + integers);
        stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
    }

    @Test
    public void test_getMax(){
        System.out.println("列表中最大的数 : " + getMax(integers));
        //Java 8
        System.out.println("列表中最大的数 : " + stats.getMax());
    }

    @Test
    public  void test_getMin(){
        System.out.println("列表中最小的数 : " + getMin(integers));
        //Java 8
        System.out.println("列表中最小的数 : " + stats.getMin());
    }

    @Test
    public  void test_getSum(){
        System.out.println("所有数之和 : " + getSum(integers));
        //Java 8
        System.out.println("所有数之和 : " + stats.getSum());
    }

    @Test
    public  void test_getAverage(){
        System.out.println("平均数 : " + getAverage(integers));
        //Java 8
        System.out.println("平均数 : " + stats.getAverage());
    }




    private static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {

            Integer number = numbers.get(i);

            if (number.intValue() > max) {
                max = number.intValue();
            }
        }
        return max;
    }

    private static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);

            if (number.intValue() < min) {
                min = number.intValue();
            }
        }
        return min;
    }

    private static int getSum(List numbers) {
        int sum = (int) (numbers.get(0));

        for (int i = 1; i < numbers.size(); i++) {
            sum += (int) numbers.get(i);
        }
        return sum;
    }

    private static int getAverage(List<Integer> numbers) {
        return getSum(numbers) / numbers.size();
    }

}