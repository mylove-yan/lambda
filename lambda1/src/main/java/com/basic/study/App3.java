/*******************************************************************************
 * @(#)App3.java 2020/6/1
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.basic.study;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda表达式类型检查
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/1 8:33
 */
public class App3 {

    public static void test(MyInterface<String, List> inter) {
        List<String> list = inter.strategy("hello", new ArrayList());
        System.out.println(list);
    }

    /*
        (x,y)->{..} --> test(param) --> param==MyInterface --> lambda表达式-> MyInterface类型
        这个就是对于lambda表达式的类型检查，MyInterface接口就是lambda表达式的目标类型(target typing)

        (x,y)->{..} --> MyInterface.strategy(T r, R r)--> MyInterface<String, List> inter
            --> T==String R==List --> lambda--> (x, y) == strategy(T t , R r)--> x==T==String  y==R==List
            lambda表达式参数的类型检查
         */
    public static void main(String[] args) {
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });

        test((x, y) -> {
            y.add(x);
            return y;
//            x.add(y);
//            return x;
        });
    }
}

@FunctionalInterface
interface MyInterface<T, R> {
    R strategy(T t, R r);
}
