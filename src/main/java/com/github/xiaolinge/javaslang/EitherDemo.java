package com.github.xiaolinge.javaslang;

import javaslang.collection.List;
import javaslang.control.Either;

public class EitherDemo {
    public static void main(String[] args) {

        Either<String, Integer> either = Either.left("xx");
        either = either.map(integer -> integer++);
        System.out.println(either);


        // List<Either<String, Integer>> list = List.of(Either.left("err"), Either.right(1));
      /*  list.map(e -> {
            if (e.isLeft()) {
                return e;
            } else {
                return Either.right(e.get() + 1);
            }
        }).stdout();*/
        //  list.map(e -> e.map(integer -> integer++)).stdout();
    }


}
