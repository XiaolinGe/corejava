package com.github.xiaolinge.codewars;

import com.github.xiaolinge.Person;
import groovy.transform.ASTTest;
import javaslang.API;
import javaslang.collection.List;
import javaslang.collection.Map;
import javaslang.control.Option;


public class SortWithArrow {

    public static void main(String[] args) {
        Map<String,String> map = API.Map();

        System.out.println(map.get("age"));

    }


    public List<Person> orderPeople(List<Person> list) {
        return list.sortBy(Person::age);

    }

    // javaslang Map  Option<V> get(K key);


    public List<Map<String, Integer>> orderPeopleMap(List<Map<String, Integer>> list) {
        return list.sortBy(e->e.get("age").getOrElse(Integer.MIN_VALUE));

    }


}
