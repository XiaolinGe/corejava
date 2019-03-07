package com.github.xiaolinge.codewars;

import javaslang.API;
import javaslang.collection.List;
import javaslang.control.Option;
import static javaslang.API.*;
// 在设计方法和方法签名的时候
// 当返回的是单个元素时， 一定返回Option, 用来避免空指针异常NPE
// 当返回的元素（即return 的数据类型）是单个元素时才使用Option, 例如 Sting
// 当需要返回单个元素的时候，保证返回的是Option,  避免调用者调用时产生空指针异常
// 而当需要返回的是一个集合的时候，要保证如果是空的情况下要返回的是空集合，而不是null, 避免调用者调用时产生空指针异常
public class UniqueInOrder {
    public List<String> unique (String str) {
       // List<String> list = List.of(str.split("")).distinct();
        return Option.of(str)
                .map(e-> e.split(""))
                .map(List::of)
                .map(List::distinct)
                .getOrElse(List.empty())
                .removeAll(String::isEmpty);
    }

    public List<Integer> unique (List<Integer> num) {
        return Option.of(num)
                .getOrElse(List.empty())
                .distinct();

    }


}



/*
* "AABBCC"
* ["A", "A", "B, "B, "C", "C"]
* ["A", "B, "C"]
* */


