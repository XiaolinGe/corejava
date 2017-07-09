package com.github.xiaolinge.codewars

import javaslang.control.Either
import spock.lang.Specification
import spock.lang.Unroll

class DescendingOrderTest extends Specification {
    DescendingOrder descendingOrder = new DescendingOrder()

    @Unroll
    def "DescendingOrder"() {
        expect:
        descendingOrder.descendingOrder(str) == res

        where:
        str   || res
        "123" || Either.right(321)
        "213" || Either.right(321)
        "32a" || Either.left("error msg: java.lang.NumberFormatException: For input string: \"32a\"")
        "abc" || Either.left("error msg: java.lang.NumberFormatException: For input string: \"abc\"")
        "1 2" || Either.left("error msg: java.lang.NumberFormatException: For input string: \"1 2\"")
        " 12" || Either.left("error msg: java.lang.NumberFormatException: For input string: \" 12\"")
        "12 " || Either.left("error msg: java.lang.NumberFormatException: For input string: \"12 \"")
        ""    || Either.left("error msg: java.lang.NumberFormatException: For input string: \"\"")
        " "   || Either.left("error msg: java.lang.NumberFormatException: For input string: \" \"")
        null  || Either.left("error msg: java.lang.NumberFormatException: null")

    }

    @Unroll
    def "DescendingOrder2"() {
        expect:
        descendingOrder.descendingOrder2(str) == res

        where:
        str   || res
        "123" || Either.right(321)
        "213" || Either.right(321)
        "32a" || Either.left("error msg: java.lang.NumberFormatException: For input string: \"32a\"")
        "abc" || Either.left("error msg: java.lang.NumberFormatException: For input string: \"abc\"")
        "1 2" || Either.left("error msg: java.lang.NumberFormatException: For input string: \"1 2\"")
        " 12" || Either.left("error msg: java.lang.NumberFormatException: For input string: \" 12\"")
        "12 " || Either.left("error msg: java.lang.NumberFormatException: For input string: \"12 \"")
        ""    || Either.left("error msg: java.lang.NumberFormatException: For input string: \"\"")
        " "   || Either.left("error msg: java.lang.NumberFormatException: For input string: \" \"")
        null  || Either.left("error msg: java.lang.NumberFormatException: null")

    }
}
