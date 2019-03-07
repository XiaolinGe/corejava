package com.github.xiaolinge.codewars

import com.github.xiaolinge.Person
import javaslang.API
import static javaslang.API.*
import javaslang.collection.List
import javaslang.collection.Map
import javaslang.control.Option
import spock.lang.Specification
import spock.lang.Unroll

class SortWithArrowTest extends Specification {
    @Unroll
    def " #list order as #res"() {
        given:
        SortWithArrow sortWithArrow = new SortWithArrow()



        expect:
        sortWithArrow.orderPeople(list) == res

        where:
        list                                                                     || res
        List.of(new Person(age: 11, name: "aa"), new Person(age: 5, name: "bb")) || List.of(new Person(age: 5, name: "bb"), new Person(age: 11, name: "aa"))
        List.of(new Person(name: "aa"), new Person(age: 5, name: "bb"))          || List.of(new Person(name: "aa"), new Person(age: 5, name: "bb"))
        List.empty()                                                             || List.empty()


    }


    @Unroll
    def "2 #list order as #res"() {
        given:
        SortWithArrow sortWithArrow = new SortWithArrow()


        expect:
        sortWithArrow.orderPeopleMap(list) == res

        where:
        list                                 || res
        List(Map("age", 11,), Map("age", 5)) || List(Map("age", 5), Map("age", 11))
        List(Map(), Map("age", 5))           || List(Map(), Map("age", 5))
        List.empty()                         || List.empty()


    }
}
