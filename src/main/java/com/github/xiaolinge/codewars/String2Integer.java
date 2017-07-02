package com.github.xiaolinge.codewars;

import javaslang.control.Option;

import javax.swing.*;


public class String2Integer {
   /* public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE - 1 == Integer.MAX_VALUE);
        益处问题，Interger最大值加一等于Interger的最小值
        益处问题，Interger最小值减一等于Interger的最大值
    }*/

    /**
     * String => Option<String> => Option<Option<Integer>> => Option<Integer>
     *
     * @param str
     * @return
     */
    public Option<Integer> parseInt(String str) {

       return Option.of(str)
                .map(e -> {
                    Option<Integer> intValue;
                    try {
                        intValue = Option.of(Integer.parseInt(e));
                    } catch (NumberFormatException e1) {
                        return Option.<Integer>none();
                    }
                    return intValue;
                }).getOrElse(Option.none());

    }
}
