package com.github.xiaolinge.codewars

import javaslang.control.Either
import javaslang.control.Option
import spock.lang.Specification
import spock.lang.Unroll

class String2IntegerTest extends Specification {
    @Unroll
    def " #str parseInt to #res"() {
        given:
        String2Integer string2Integer = new String2Integer()

        expect:
        string2Integer.parseInt(str) == res

        where:
        str                 || res
        "10"                || Option.of(10)
        "10e"               || Option.none()
        ""                  || Option.none()
        " "                 || Option.none()
        null                || Option.none()
        Long.MAX_VALUE + "" || Option.none()
        Long.MIN_VALUE + "" || Option.none()

    }

    @Unroll
    def "either #str parseInt to #res"() {
        given:
        String2Integer string2Integer = new String2Integer()

        expect:
        string2Integer.parseIntEither(str) == res

        where:
        str                 || res
        "10"                || Either.right(10)
        "10e"               || Either.left("For input string: \"10e\"")
        ""                  || Either.left("For input string: \"\"")
        " "                 || Either.left("For input string: \" \"")
        null                || Either.left("input str is null")
        Long.MAX_VALUE + "" || Either.left("Out of Integer's range")
        Long.MIN_VALUE + "" || Either.left("Out of Integer's range")

    }
}
