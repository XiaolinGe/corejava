package com.github.xiaolinge.javaslang;

import com.github.xiaolinge.codewars.String2Integer;
import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.List;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TryDemo {

    // try either option
    public static void main(String[] args) {
      //  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

       // String dateStr = "198";
     //   Try<Date> dateTry = Try.of(() -> simpleDateFormat.parse(dateStr));
     //   Either<Throwable, Date> dateEither = dateTry.toEither();
      //  Option<Date> dateOption = dateTry.toOption();

      //  System.out.println(dateEither);
      //  System.out.println(dateOption);


        //  dateAfter("1988-08-13");
        //  dateAfter("2988-08-13");
        //dateAfter("2-08-");
        // eitherTest();
          parserIntAndDosomething();

    }


    public static void parserIntAndDosomething() {

        List<String> inputs = List.of("1", "2", "xx", null, "", "44", Long.MAX_VALUE + "");
        inputs.map(e -> new String2Integer().parseIntEither(e))
                .map(e -> e.map(integer -> integer++))
                .stdout();
        // List<String> inputs2 = List.of("1", "2");

        //inputs.map(Integer::parseInt).map(e -> e++).stdout();

    }

    public static void eitherTest() {
        List<Tuple2<String, Integer>> tuple2s = List.empty();
        tuple2s = tuple2s.append(Tuple.of("str", 1));
        tuple2s = tuple2s.append(Tuple.of("str", 2));

        List<Either<String, Integer>> ints = List.empty();
        ints = ints.append(Either.left("error msg"));
        ints = ints.append(Either.right(1));

        tuple2s.stdout();
        ints.stdout();


    }

    private static void dateAfter(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Try<Date> dateTry = Try.of(() -> simpleDateFormat.parse(dateStr));
        System.out.println(dateTry.isSuccess());
        System.out.println(dateTry.isFailure());
        System.out.println(dateTry.getOrElse(new Date()));
        Date date = dateTry.get();

        boolean result = date.after(new Date());
        System.out.println(date + "在今天之前吗？" + result);
    }

    private static void opTest() {
        Option<Integer> integerOption = Option.of(null);
        System.out.println(integerOption.isDefined());
        System.out.println(integerOption.isEmpty());
        System.out.println(integerOption.getOrElse(-1));
        Integer intVal = integerOption.get();
    }
}
