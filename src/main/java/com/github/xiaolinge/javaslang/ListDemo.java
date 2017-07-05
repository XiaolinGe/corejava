package com.github.xiaolinge.javaslang;

import javaslang.API;
import javaslang.collection.List;
import javaslang.control.Option;


public class ListDemo {

    public boolean all(List<Integer> list) {
        if (list != null && list.length() == 0) {
            return false;
        }else {
            return Option.of(list)
                    .map(e -> e.forAll(e2 -> e2 > 0))
                    .getOrElse(false);
        }
    }

    public boolean none(List<Integer> list) {
        if (list != null && list.length() == 0) {
            return false;
        }else {
            return Option.of(list)
                    .map(e -> e.forAll(e2 -> e2 <= 0))
                    .getOrElse(false);
        }
    }

    public boolean any(List<Integer> list) {
        if (list != null && list.length() == 0) {
            return false;
        }else {
            return !Option.of(list)
                    .map(e -> e.filter(e2 -> e2 > 0))
                    .map(List::length)
                    .getOrElse(0)
                    .equals(0);
        }
    }

}
