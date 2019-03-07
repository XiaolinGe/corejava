package com.github.xiaolinge.codewars;


import javaslang.collection.List;
import javaslang.control.Option;
import javaslang.control.Try;

public class ShortTest {

    public static void main(String[] args) {

    }

    public  Integer findShort(String str) {

        return Option.of(str)
                .map(e -> e.replaceAll("( )+"," "))
                .map(e -> e.split(" "))
                .map(List::of)
                .map(List::distinct)
                .map(e3 -> e3.map(String::length))
                .map(List::sorted)
                .map(e -> Try.of(e::head).getOrElse(0))
                .getOrElse(0);

    }

}


/*
* List.of(2,1,3,4)
*
* */