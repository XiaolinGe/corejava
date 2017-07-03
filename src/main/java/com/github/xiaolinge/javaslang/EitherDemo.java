package com.github.xiaolinge.javaslang;

import javaslang.collection.List;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;

import java.text.MessageFormat;

public class EitherDemo {

    public List<Either<String, Integer>> map(List<Either<String, Integer>> intsEither) {
        return intsEither
                .map(intEither -> intEither.map(e -> e + 1));
    }

    public List<Either<String, Integer>> mapLeft(List<Either<String, Integer>> intsEither) {
        return intsEither
                .map(intEither -> intEither.mapLeft(e -> MessageFormat.format("error msg: {0}", e)));

    }

    public List<Either<String, Integer>> biMap(List<Either<String, Integer>> intsEither) {
        return intsEither
                .map(intEither -> intEither.bimap(err -> MessageFormat.format("error msg: {0}", err), intVal -> intVal+1));
    }

    public Either<String, String> left(String str) {
        return Try.of(() -> str.substring(0,3))
                .toEither()
                .mapLeft(ex -> "err");

    }

    public Either<String, String> right(String str) {
        return Either.right(str.substring(0,3));
    }
}
