package com.basic.study;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Test t = ()->{

            return "成功";
        };

        System.out.println( t.test());
    }
    @FunctionalInterface
    public interface Test{
        String test();
    }
}
