/*******************************************************************************
 * @(#)JDKGive.java 2020/5/28
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.basic.study;

import java.util.UUID;
import java.util.function.*;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/5/28 15:41
 */
public class JDKGive {

    /*
        java.util.function提供了大量的函数式接口
        Predicate 接收参数T对象，返回一个boolean类型结果
        Consumer 接收参数T对象，没有返回值
        Function 接收参数T对象，返回R对象
        Supplier 不接受任何参数，直接通过get()获取指定类型的对象
        UnaryOperator 接口参数T对象，执行业务处理后，返回更新后的T对象
        BinaryOperator 接口接收两个T对象，执行业务处理后，返回一个T对象
         */

    // 1. lambda表达式的基本语法
        /*
        1)声明：就是和lambda表达式绑定的接口类型
        2)参数：包含在一对圆括号中，和绑定的接口中的抽象方法中的参数个数及顺序一致。
        3)操作符：->
        4)执行代码块：包含在一对大括号中，出现在操作符号的右侧

        [接口声明] = (参数) -> {执行代码块};
        /*
        1. lambda表达式，必须和接口进行绑定。
        2. lambda表达式的参数，可以附带0个到n个参数，括号中的参数类型可以不用指定，jvm在运行时，会自动根据绑定的抽象方法中电参数进行推导。
        3. lambda表达式的返回值，如果代码块只有一行，并且没有大括号，不用写return关键字，单行代码的执行结果，会自动返回。
            如果添加了大括号，或者有多行代码，必须通过return关键字返回执行结果。
         */
    public static void main(String[] args) {


        // 三、JDK8 提供的常见函数式接口
        Predicate<String> pre = (String username) -> {
            return "admin".equals(username);
        };

        System.out.println(pre.test("manager"));
        System.out.println(pre.test("admin"));

        Consumer<String> con = (String message) -> {
            System.out.println("要发送的消息：" + message);
            System.out.println("消息发送完成");
        };
        con.accept("hello 慕课网的学员们..");
        con.accept("imooc lambda expression.");

        Function<String, Integer> fun = (String gender) -> {
            return "male".equals(gender) ? 1 : 0;
        };
        System.out.println(fun.apply("male"));
        System.out.println(fun.apply("female"));

        Supplier<String> sup = () -> {
            return UUID.randomUUID().toString();
        };
        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());

        UnaryOperator<String> uo = (String img) -> {
            img += "[100x200]";
            return img;
        };

        System.out.println(uo.apply("原图--"));

        BinaryOperator<Integer> bo = (Integer i1, Integer i2) -> {
            return i1 > i2 ? i1 : i2;
        };

        System.out.println(bo.apply(12, 13));


    }
}


