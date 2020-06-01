/*******************************************************************************
 * @(#)App4.java 2020/6/1
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.basic.study;

/**
 * 方法重载和Lambda表达式
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/1 8:41
 */
public class App4 {

    interface Param1 {
        void outInfo(String info);
    }

    interface Param2 {
        void outInfo(String info);
    }


    // 定义重载的方法
    public void lambdaMethod(Param1 param) {

        param.outInfo("hello param1 imooc!");
    }

    public void lambdaMethod(Param2 param) {

        param.outInfo("hello param2 imooc");
    }

    public static void main(String[] args) {
        App4 app = new App4();

        app.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        app.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println("------");
                System.out.println(info);
            }
        });

        /*
        lambda表达式存在类型检查-> 自动推导lambda表达式的目标类型
        lambdaMethod() -> 方法 -> 重载方法
                -> Param1  函数式接口
                -> Param2  函数式接口
                调用方法-> 传递Lambda表达式-> 自动推导->
                    -> Param1 | Param2
         */
//        app.lambdaMethod( (String info) -> {
//            System.out.println(info);
//        });
    }
}
