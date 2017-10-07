package com.github.xiaolinge.fns;

import javaslang.Function2;
import javaslang.collection.List;
import javaslang.control.Try;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FnTest {

    @Test
    public void givenJava8Function_whenWorks_thenCorrect() {
        Function<Integer, Integer> square = (num) -> num * num;

        Function2<Integer, Integer,Integer> execForLongTime = (a1,a2) -> {
            Try.run(()->TimeUnit.SECONDS.sleep(5));
            System.out.println("exec for a long time ,args ["+a1+"---"+a2+"]");
            return a1+a2 ;
        };

        Function2<Integer,Integer, Integer> multiply = (Integer num, Integer num2) -> {
            return num * num2;
        };



        Function<Integer,Integer> multiplyBy2 = multiply.apply(2);

       // System.out.println(multiplyBy2.apply(4));


        Function<Integer,Integer> multiplyBy4 = multiply.apply(4);



        Function<Integer, Integer> multiplyBy8 = multiplyBy4.andThen(multiplyBy2);

        Function<Integer,Integer> squareAndMultiply = square.andThen(multiplyBy4);
        int result = square.apply(2);


        List<Integer> list = List.of(1, 2, 3);
        //list.map(square).stdout();
       // list.map(multiplyBy2).stdout();
       // list.map(multiplyBy4).stdout();
        //list.map(squareAndMultiply).stdout();//


        Function2<Integer, Integer, Integer> memoized = execForLongTime.memoized();
        System.out.println(memoized.apply(1, 2));
        System.out.println("=============");
        System.out.println(memoized.apply(1, 2));
        System.out.println(memoized.apply(1, 2));
        System.out.println(memoized.apply(1, 2));
        System.out.println(memoized.apply(1, 2));
        System.out.println(memoized.apply(1, 2));
        System.out.println(memoized.apply(3, 2));
        System.out.println(memoized.apply(3, 2));



    }
}
