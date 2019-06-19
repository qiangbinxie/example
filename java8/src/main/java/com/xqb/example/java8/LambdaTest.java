package com.xqb.example.java8;

public class LambdaTest {

    public static void main(String[] args) {

        LambdaTest lambdaTest = new LambdaTest();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction  = ( a,  b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication   = (int a, int b) -> { return a * b; };

        System.out.println("10+5= " +  lambdaTest.action(addition));
        System.out.println("10-5= " +  lambdaTest.action(subtraction));
        System.out.println("10*5= " +  lambdaTest.action(multiplication));

        //不用定义变量
        System.out.println("10*5= " +  lambdaTest.action( (a,  b) -> a / b));
    }

    public int action(MathOperation operation) {
        int a = 10;
        int b = 5;
        return operation.run(a,b);
    }
}

@FunctionalInterface
interface MathOperation {
    int run(int a, int b);
}

