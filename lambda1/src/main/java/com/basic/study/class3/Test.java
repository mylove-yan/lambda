/*******************************************************************************
 * @(#)Test.java 2020/6/1
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.basic.study.class3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/1 9:00
 */
public class Test {
        public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("shuke", "男", 29));
        list.add(new Person("tom", "男", 16));
        list.add(new Person("jerry", "男", 20));
        list.add(new Person("beita", "女", 30));

        // 匿名内部类实现
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        // lambda表达式实现
        Collections.sort(list, (p1, p2) -> p1.getAge() - p2.getAge());
        // 静态方法引用实现
        Collections.sort(list, Person::compareByAge);

        // 实例方法引用
        PersonUtil pu = new PersonUtil();
        Collections.sort(list, pu::comprareByName);

        list.forEach(System.out::println);

        IPerson p1 = Person::new;
        Person person = p1.getPerson("tom", "男", 18);
        System.out.println(person);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String name;
    private String gender;
    private int age;

    // 静态方法引用
    public static int compareByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }

}
class PersonUtil {
    // 实例方法引用
    public int comprareByName(Person p1, Person p2) {
        return p1.getName().hashCode() - p2.getName().hashCode();
    }
}

interface IPerson {
    Person getPerson(String name, String gender, int age);
}



