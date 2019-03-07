package com.github.xiaolinge.codewars

import spock.lang.Specification
import spock.lang.Unroll

class CalculatorTest extends Specification {
    @Unroll
    def " #a plus #b is #c"() {
        given:
        Calculator calculator = new Calculator()

        expect:
        calculator.add(a, b) == c

        where:
        a | b || c
        1 | 1 || 2
        2 | -2 || 0
        -1 | 3 || 0
    }
}
