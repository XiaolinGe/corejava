package com.github.xiaolinge.javaslang

import javaslang.collection.List
import spock.lang.Specification
import spock.lang.Unroll


class ListDemoTest extends Specification {
    ListDemo listDemo = new ListDemo()

    @Unroll
    def "List all > 0"() {
        expect:
        listDemo.all(list) == res

        where:
        list            || res
        List.of(1, 2)   || true
        List.of(0, 1)   || false
        List.of(0, -1)  || false
        List.of(-1, -2) || false
        List.of()       || false
        null            || false

    }

    @Unroll
    def "List none > 0"() {
        expect:
        listDemo.none(list) == res

        where:
        list            || res
        List.of(-1, -2) || true
        List.of(0, -1)  || true
        List.of(0, 0)   || true
        List.of(1, 2)   || false
        List.of(0, 1)   || false
        List.of()       || false
        null            || false

    }

    @Unroll
    def "List any > 0"() {
        expect:
        listDemo.any(list) == res
        
        where:
        list            || res
        List.of(-1, -2) || false
        List.of(0, -1)  || false
        List.of(0, 0)   || false
        List.of(1, 2)   || true
        List.of(0, 1)   || true
        List.of(-1, 1)  || true
        List.of()       || false
        null            || false

    }
}
