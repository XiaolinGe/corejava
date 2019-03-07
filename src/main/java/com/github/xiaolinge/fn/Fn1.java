package com.github.xiaolinge.fn;

import javaslang.Function2;

public class Fn1 {

    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> addFn = (i, j) -> i + j;
        int result = addFn.apply(1,2);
        System.out.println(result);
    }



}
