package com.github.xiaolinge.javaslang

import javaslang.collection.List
import javaslang.control.Either
import spock.lang.Specification
import spock.lang.Unroll

import static javaslang.API.List
import static javaslang.API.Map

class TryDemoTest extends Specification {

    @Unroll
    def "toEither"() {
        given:
        TryDemo tryDemo = new TryDemo()

        expect:
        tryDemo.toEither(str) == res
        where:
        str                 || res
        "10"                || Either.right(10)
        "10e"               || Either.left("For input string: \"10e\"")
        ""                  || Either.left("For input string: \"\"")
        " "                 || Either.left("For input string: \" \"")
        null                || Either.left("input str is null")
        Long.MAX_VALUE + "" || Either.left("For input string: " + "\"" + Long.MAX_VALUE + "\"")
        Long.MIN_VALUE + "" || Either.left("For input string: " + "\"" + Long.MIN_VALUE + "\"")

    }
}
