package com.github.xiaolinge;

import javaslang.Tuple2;
import javaslang.collection.List;
import javaslang.collection.Map;
import javaslang.collection.Stream;
import javaslang.collection.Traversable;
import org.junit.Test;

import java.util.function.Function;

import static javaslang.API.List;
import static javaslang.API.Tuple;

public class JavaslangTest {

    @Test
    public void createObject() {
        Person person1 = Person.of().age(10).name("xx");
        System.out.println(person1);
        System.out.println(person1.age());
        //sout
    }

    @Test
    public void createObject2() {
        Person person1 = Person.of().age(10).name("gg");
        System.out.println(person1);
        System.out.println(person1.name());
    }

    @Test
    public void createList() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        List<Person> persons = List(person1, person2);
        System.out.println(persons);
        persons.forEach(e -> System.out.println(e));
    }

    @Test
    public void createList2() {
        Person person1 = Person.of().age(10).name("hello");
        Person person2 = Person.of().age(12).name("world");
        List<Person> persons = List(person1, person2);
        System.out.println(persons);
        persons.forEach(e-> System.out.println(e));
    }

    @Test
    public void filterAndMap() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        List<Person> persons = List(person1, person2);
        List<String> names = persons.filter(p -> p.age() > 12)
                .map(e -> e.name());
        names.forEach(e -> System.out.println(e));
    }

    @Test
    public void filterAndMap2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(11).name("bb");
        List<Person> persons = List(person1, person2);
        List<String> names = persons.filter(p->p.age() > 10)
                .map(e -> e.name());
        names.forEach(e -> System.out.println(e)); // why do not use map but forEach, what is the different?
    }


    @Test
    public void sum() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);

        Number total = persons.filter(e -> e.name().length() <= 2)
                .map(e -> e.age())
                .sum();
        System.out.println(total);
    }

    @Test
    public void sum2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(11).name("bb");
        Person person3 = Person.of().age(11).name("ccc");
        List<Person> persons = List(person1, person2, person3);
        Number total = persons.filter(p -> p.name().length() <= 2)
                .map(e -> e.age())
                .sum();
        System.out.println(total);
    }


    @Test
    public void reduce() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);

        Number total = persons.filter(e -> e.name().length() <= 2)
                .map(e -> e.age())
                .reduce((l, r) -> l + r);

        System.out.println(total);
    }

    @Test
    public void reduce2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(11).name("bb");
        Person person3 = Person.of().age(12).name("ccc");
        List<Person> persons = List(person1, person2, person3);
        Number total = persons.filter(e -> e.name().length() <= 2)
                .map(e -> e.age())
                .reduce((pre, cur) -> pre + cur);
        System.out.println(total);
    }



    @Test
    public void groupBy() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("y");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);
        Map<Integer, List<Person>> result = persons.groupBy(e -> e.name().length());
        System.out.println(result);
    }


    @Test
    public void groupBy2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(11).name("bb");
        Person person3 = Person.of().age(12).name("ccc");
        List<Person> persons = List(person1, person2, person3);
        Map<Integer, List<Person>> result = persons.groupBy(e -> e.name().length());
        System.out.println(result);
    }

    @Test
    public void groupAndMap() {

        List<String> list = List("apple", "orange", "banana", "papaya", "banana");
        list.groupBy(Function.identity())
                .map(e -> Tuple(e._1, e._2.size()))
                .stdout();

    }

    @Test
    public void groupAndMap2() {
        List<String> list = List("apple",  "orange", "banana", "papaya", "banana");
        list.groupBy(Function.identity())
                .map(e -> Tuple(e._1, e._2))
                .stdout();
    }

    @Test
    public void combination() {
        List(1, 2, 3, 4, 5).combinations().stdout();
    }

    @Test
    public void combination2() {
        System.out.println(List(1,2).combinations());
    }


    @Test
    public void flatMap() {
        List<String> list = List("apple", "orange", "banana", "papaya", "banana");
        List<String> list2 = List("apple", "orange", "banana", "papaya", "banana");
        List<List<String>> lists = List(list, list2);
        List<String> flatedList = lists.flatMap(Traversable::iterator);
        flatedList.stdout();
    }

    @Test
    public void flatMap2() {
        List<String> list1 = List("apple", "orange", "banana", "papaya", "cherry");
        List<String> list2 = List("apple", "orange", "banana", "papaya", "cherry");
        List<List<String>> lists = List(list1, list2);
        List<String > flatedList = lists.flatMap(e -> e.iterator());
        System.out.println(flatedList);
        flatedList.stdout();
    }

    @Test
    public void partition() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);
        Tuple2<List<Person>, List<Person>> result = persons.partition(e -> e.age() > 12);
        System.out.println(result);

    }

    @Test
    public void partition2() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);
        Tuple2<List<Person>, List<Person>> res = persons.partition(e -> e.age()>13);
        System.out.println(res);

    }


    @Test
    public void sort() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);
        persons.sortBy(e -> e.age()).stdout();
    }

    @Test
    public void sort2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(14).name("aA");
        Person person3 = Person.of().age(16).name("Acc");
        List<Person> persons = List(person1, person2, person3);
        List<Person> res = persons.sortBy(e -> e.name());
        System.out.println(res);
    }

    @Test
    public void split() {
        String s = "1024";
        List<String> result = List(s.split("")).intersperse(",");
        System.out.println(result);
        result.forEach(e -> System.out.println(e));
    }

    @Test
    public void split2() {
        String s = "1024";
        List<String> res = List(s.split("")).intersperse("%");
        System.out.println(res);
    }

    @Test
    public void concat() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");

        Person person4 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);

        List<Person> newPersons = persons.append(person4);

        System.out.println(persons);

        System.out.println(newPersons);

    }

    @Test
    public void concat2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(14).name("bb");
        Person person3 = Person.of().age(16).name("ccc");

        Person person4 = Person.of().age(16).name("ddd");
        List<Person> persons = List(person1, person2, person3);
        List<Person> newPersons = persons.append(person4);
        System.out.println(persons);
        System.out.println(newPersons);

    }



    @Test
    public void contains() {
        Person person1 = Person.of().age(10).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");

        Person person4 = Person.of().age(16).name("zzz");

        List<Person> persons = List(person1, person2, person3);


        boolean result = persons.contains(person3);
        System.out.println(result);


        boolean result2 = persons.contains(person4);
        System.out.println(result2);
    }

    @Test
    public void contains2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(14).name("bb");
        Person person3 = Person.of().age(16).name("cc");

        Person person4 = Person.of().age(16).name("cc");
        Person person5 = Person.of().age(18).name("dd");

        List<Person> persons = List(person1, person2, person3);

        boolean res1 = persons.contains(person4);
        boolean res2 = persons.contains(person5);
        System.out.println(res1);
        System.out.println(res2);
    }


    @Test
    public void some() {
        //TODO
        Person person1 = Person.of().age(1).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");

        Person person21 = Person.of().age(11).name("xx");
        Person person22 = Person.of().age(5).name("yy");
        Person person23 = Person.of().age(7).name("zzz");

        List<Person> persons = List(person1, person2, person3);

        List<Person> persons2 = List(person21, person22, person23);

    }

/*    @Test
    public void ftp() {
        FTPDownloader ftpDownloader = new FTPDownloader("ftp.olsendata.com", "cfgglobal", "m1n9yuan");
        String filePath = "~/";
        ftpDownloader.downloadFile("last", filePath);
    }*/

    @Test
    public void distinct() {
        Person person1 = Person.of().age(1).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");

        Person person4 = Person.of().age(1).name("xx");
        Person person5 = Person.of().age(14).name("yy");
        Person person6 = Person.of().age(16).name("zzz");

        List<Person> persons = List(person1, person2, person3, person4, person5, person6);
        persons.distinct().stdout();

    }

    @Test
    public void distinct2() {
        Person person1 = Person.of().age(1).name("aa");
        Person person2 = Person.of().age(14).name("bb");
        Person person3 = Person.of().age(16).name("ccc");

        Person person4 = Person.of().age(1).name("aa");
        Person person5 = Person.of().age(14).name("bb");
        Person person6 = Person.of().age(16).name("ccc");

        List<Person> persons = List(person1, person2, person3, person4, person5, person6);
        List<Person> res = persons.distinct();
        System.out.println(res);

    }

    @Test
    public void average() {
        Person person1 = Person.of().age(1).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);

        persons.reverse()
                .map(e -> e.age())
                .average()
                .stdout();
    }

    @Test
    public void average2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(13).name("bb");
        Person person3 = Person.of().age(16).name("ccc");

        List<Person> persons = List(person1, person2, person3);
        persons.map(e -> e.age())
                .average()
                .stdout();
    }

    @Test
    public void shuffle() {

        Person person1 = Person.of().age(1).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);
        persons.shuffle().stdout();
    }

    @Test
    public void shuffle2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(13).name("bb");
        Person person3 = Person.of().age(16).name("ccc");
        Person person4 = Person.of().age(12).name("ddd");

        List<Person> persons = List(person1, person2, person3, person4);
        List<Person> newPersons = persons.shuffle();
        System.out.println(newPersons);
    }


    @Test
    public void reverse() {

        Person person1 = Person.of().age(1).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);
        persons.reverse().stdout();
    }

    @Test
    public void reverse2() {
        Person person1 = Person.of().age(10).name("a");
        Person person2 = Person.of().age(11).name("bb");
        Person person3 = Person.of().age(12).name("ccc");
        List<Person> persons = List(person1, person2, person3);
        List<Person> res = persons.reverse();
        System.out.println(res);
    }

    @Test
    public void zipwithindex() {
        Person person1 = Person.of().age(1).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);
        persons.zipWithIndex().stdout();

    }

    @Test
    public void zipwithindex2() {
        Person person1 = Person.of().age(10).name("aa");
        Person person2 = Person.of().age(11).name("bb");
        Person person3 = Person.of().age(12).name("ccc");
        List<Person> persons = List(person1, person2, person3);
        List<Tuple2<Person,Integer>> res = persons.zipWithIndex();
        System.out.println(res);

    }

    @Test
    public void zip() {
        List<Integer> list = List(1, 2, 3, 4, 5, 6);
        List<String> list2 = List("a", "b");
        list.zip(list2).stdout();
    }

    @Test
    public void zip2() {
        List<Integer> list1 = List(1,2,3,4,5);
        List<String> list2  = List("a", "b", "c", "d");
        List<Tuple2<Integer, String>> res = list1.zip(list2);
        System.out.println(res);
    }


    @Test
    public void forAll() {
        Person person1 = Person.of().age(20).name("xx");
        Person person2 = Person.of().age(14).name("yy");
        Person person3 = Person.of().age(16).name("zzz");
        List<Person> persons = List(person1, person2, person3);

        boolean result = persons.forAll(e -> e.age() > 15);
        System.out.println(result);

    }

    @Test
    public void product() {
        Person person1 = Person.of().age(2).name("xx");
        Person person2 = Person.of().age(3).name("yy");
        Person person3 = Person.of().age(5).name("zzz");
        List<Person> persons = List(person1, person2, person3);
        System.out.println(persons.map(e -> e.age()).product());
    }

    @Test
    public void product2() {
        Person person1 = Person.of().age(2).name("aa");
        Person person2 = Person.of().age(3).name("bb");
        Person person3 = Person.of().age(5).name("ccc");
        List<Person> persons = List(person1, person2, person3);
        Number res = persons.map(e -> e.age()).product();
        System.out.println(res);
    }



    @Test
    public void max() {
        Person person1 = Person.of().age(2).name("xx");
        Person person2 = Person.of().age(3).name("yy");
        Person person3 = Person.of().age(5).name("zzz");
        List<Person> persons = List(person1, person2, person3);

        persons.maxBy(e -> e.age())
                .stdout();
    }

    @Test
    public void max2() {
        Person person1 = Person.of().age(2).name("aa");
        Person person2 = Person.of().age(3).name("bb");
        Person person3 = Person.of().age(5).name("ccc");
        List<Person> persons = List(person1, person2, person3);

        System.out.println(persons.maxBy(e -> e.age()));
    }

    @Test
    public void streamuntile() {
        Stream<Integer> stream = Stream.from(0);
        System.out.println(stream);

        stream.takeUntil(e -> e > 10).stdout();
        stream.filter(e -> e % 2 == 0).takeUntil(e -> e > 10).stdout();
    }

    @Test
    public void streamuntile2() {
        Stream<Integer> stream = Stream.from(0);
        Stream<Integer> res = stream.takeUntil(e -> e > 10);
        System.out.println(stream);
        System.out.println(res);
        stream.takeUntil(e -> e > 5).stdout();
    }

    @Test
    public void streamtake() {
        Stream.from(1).take(10).stdout();
        System.out.println(Stream.from(1).take(10).product());
        System.out.println(Stream.from(0).take(100).sum());
    }

    @Test
    public void streamtake2() {
        Stream<Integer> stream = Stream.from(1).take(10);
        Number res1 = stream.sum();
        Number res2 = stream.product();
        System.out.println(stream);
        System.out.println(res1);
        System.out.println(res2);

    }


    @Test
    public void streamwhile() {
        //TODO
        System.out.println(Stream.from(0).takeWhile(e -> e > 10));

    }

    @Test
    public void splitAt() {
        List<Integer> list = List(1, 2, 3, 4, 5);
        System.out.println(list.splitAt(e -> e > 2));
    }

    @Test
    public void splitAt2() {
        List<Integer> list = List(1,2,3,4,5);
        Tuple2<List<Integer>, List<Integer>> res1 = list.splitAt(e -> e > 2);
        Tuple2<List<Integer>, List<Integer>> res2 = list.partition(e -> e > 2);
        System.out.println(res1);
        System.out.println(res2);
    }


}
