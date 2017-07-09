package com.github.xiaolinge.codewars;


import javaslang.collection.List;
import javaslang.control.Option;

public class Isograms {

    public static void main(String[] args) {
        System.out.println(List.of("a  b".split("")).distinct().length());
    }

    public boolean isograms(String str) {
        if(str == null) {
            return false;
        }
        return str.length() == Option.of(str)
                .map(String::toLowerCase)
                .map(e -> e.split(""))
                .map(List::of)
                .map(List::distinct)
                .map(e -> e.reduce((l, r) -> l + r))
                .getOrElse("")
                .length();
    }
}
