package com.github.xiaolinge.javaslang

import javaslang.control.Either
import spock.lang.Specification
import spock.lang.Unroll

import static javaslang.API.List;

class EitherDemoTest extends Specification {
    EitherDemo eitherDemo = new EitherDemo()


    @Unroll
    def "Map"() {
        expect:
        eitherDemo.map(intsEither) == res

        where:
        intsEither                                || res
        List(Either.left("Err"), Either.right(1)) || List(Either.left("Err"), Either.right(2))
    }

    def "MapLeft"() {
        expect:
        eitherDemo.mapLeft(intsEither) == res

        where:
        intsEither                                || res
        List(Either.left("Err"), Either.right(1)) || List(Either.left("error msg: Err"), Either.right(1))
    }

    def "BiMap"() {
        expect:
        eitherDemo.biMap(intsEither) == res

        where:
        intsEither                                || res
        List(Either.left("Err"), Either.right(1)) || List(Either.left("error msg: Err"), Either.right(2))
    }

    def "left"() {
        expect:
        eitherDemo.left(str) == res

        where:
        str     || res
        "ab" || Either.left("err")
    }


    def "right"() {
        expect:
        eitherDemo.right(str) == res

        where:
        str     || res
        "abcdefg" || Either.right("abc")
    }


}
