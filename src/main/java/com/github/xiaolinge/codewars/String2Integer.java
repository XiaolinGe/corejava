package com.github.xiaolinge.codewars;

import javaslang.API;
import javaslang.Patterns;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


/**
 * Try  Either  | Option  try 是特殊的either
 * http://blog.xebia.com/try-option-or-either/
 */
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
    public Option<Integer> parseInt2(String str) {
        return Option.of(str)
                .map(e -> {
                    Option<Integer> intValue;
                    try {
                        intValue = Option.of(Integer.parseInt(e));
                    } catch (NumberFormatException e1) {
                        return Option.<Integer>none();
                    }
                    return intValue;
                })
                .getOrElse(Option.none());
    }

    public Option<Integer> parseInt(String str) {

        return Option.of(str)
                .map(e -> Try.of(() -> Integer.parseInt(e))
                        .map(Option::of)
                        .getOrElse(Option.none()))
                .getOrElse(Option.none());

    }



   public Either<String, Integer> parseIntEither(String str) {

        return Option.of(str)
                .map(e -> Try.of(() -> Integer.parseInt(e)).toEither())
                .map(e -> e.mapLeft(ex -> {
                    ex.printStackTrace();
                    String message = ex.getMessage();
                   if (Pattern.matches("[-]?\\d+",StringUtils.substringBetween(message,"For input string: \"","\""))){
                        return "Out of Integer's range";
                    }
                    return message;
                }))
                .getOrElse(Either.left("input str is null"));
    }

}
