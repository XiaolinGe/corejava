package com.github.xiaolinge.codewars

import spock.lang.Specification
import spock.lang.Unroll

import static javaslang.API.List;

class UniqueInOrderTest extends Specification {
    @Unroll
    def "#str split as #res"() {
        given:
        UniqueInOrder uniqueInOrder = new UniqueInOrder();

        expect:
        uniqueInOrder.unique(str) == res

        where:
        str                 || res
        "AABBCC"            || List("A", "B", "C")
        "AABB CC"           || List("A", "B", " ", "C")
        null                || List()
        ""                  || List()
        " "                 || List(" ")
        List()              || List()
        List(1, 2, 2, 3, 3) || List(1, 2, 3)

    }
}
