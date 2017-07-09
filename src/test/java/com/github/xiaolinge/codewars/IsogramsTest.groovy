package com.github.xiaolinge.codewars

import spock.lang.Specification
import spock.lang.Unroll

class IsogramsTest extends Specification {
    Isograms isograms = new Isograms();

    @Unroll
    def "Isograms"() {
        expect:
        isograms.isograms(str) == res

        where:
        str    || res
        "a"    || true
        "ab"   || true
        "aB"   || true
        ""     || true
        " "    || true
        "a b"  || true
        "aab"  || false
        "aba"  || false
        "aAb"  || false
        "abA"  || false
        "a  b" || false
        null   || false

    }
}
