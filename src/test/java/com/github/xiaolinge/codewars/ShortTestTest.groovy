package com.github.xiaolinge.codewars

import spock.lang.Specification
import spock.lang.Unroll

class ShortTestTest extends Specification {
    @Unroll
    def "#str the min length is #res"() {
        given:
        ShortTest shortTest = new ShortTest();

        expect:
        shortTest.findShort(str) == res

        where:
        str                  || res
        "this is a test"     || 1
        "this     is a test" || 1
        ""                   || 0
        " "                  || 0
        null                 || 0


    }
}
