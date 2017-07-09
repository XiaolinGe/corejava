package com.github.xiaolinge.codewars;

import javaslang.collection.List;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;

import java.text.MessageFormat;

public class DescendingOrder {

    public static void main(String[] args) {
        System.out.println(List.of("2", "1", "3")
                .sorted()
                .reverse()
                .reduce((l, r) -> l + r));
    }

    public Either<String, Integer> descendingOrder(String str) {
        return Try.of(() -> Integer.parseInt(str))
                .toEither()
                .bimap(err -> MessageFormat.format("error msg: {0}", err),
                        val -> Option.of(val)
                                .map(Object::toString)
                                .map(e1 -> e1.split(""))
                                .map(List::of)
                                .map(List::sorted)
                                .map(List::reverse)
                                .map(e5 -> e5.reduce((l, r) -> l + r))
                                .map(String::toString)
                                .map(Integer::parseInt)
                                .getOrElse(0)

                );
    }

    public Either<String, Integer> descendingOrder2(String str) {
        return Try.of(() -> Integer.parseInt(str))
                .toEither()
                .bimap(err -> MessageFormat.format("error msg: {0}", err),
                        val -> {
                            String srtRes = List.of(val.toString()
                                    .split(""))
                                    .sorted()
                                    .reverse()
                                    .reduce((l, r) -> l + r);
                            return Integer.parseInt(srtRes);
                        }
                );
    }
}
