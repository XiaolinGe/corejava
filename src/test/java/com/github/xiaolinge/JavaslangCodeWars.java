package com.github.xiaolinge;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.List;
import javaslang.collection.Queue;
import javaslang.collection.SortedSet;
import javaslang.collection.TreeSet;
import javaslang.control.Option;
import org.junit.Test;

import java.io.File;
import java.util.Comparator;

import static javaslang.API.List;

public class JavaslangCodeWars {

    @Test
    public void createObject() {
        Person person1 = Person.of().age(10).name("xx");
        System.out.println(person1);
        System.out.println(person1.age());
        //sout
    }

    @Test
    public void uniqueInOrder() {
        String string = "AABBCC";
        List<String> list1 = List(string.split("BB"));
        List<String> list = List(string.split(""));
        List<String> res = list.distinct();
        String s = "";
        System.out.println(list1);
        System.out.println(list);
        System.out.println(res);
    }

    @Test
    public void likes() {
        List<String> list = List("Alex", "Jacob", "Mark", "Max", "Jane");
        System.out.println(list.splitAt(2));
       // Tuple2<List<String>,List<String>> newl = list.map(e -> );

    }

    @Test
    public void readFiles() {
        //File folder = new File("/Users/gexiaolin/git/automation/src/test/java/com/cfgglobal/automation");
        File folder = new File("/Users/gexiaolin/git/automation/payease");

        File[] listOfFiles = folder.listFiles();
        List<String> res = List(listOfFiles).map(e -> e.getAbsolutePath());
        System.out.println(res);
    }

    @Test
    public void readFilesName() {
        List<String> orderIds = List("haha","20161223-8321-10028421081803","20161223-8321-10028421081802", "8321002_20151210151747");
        File folder = new File("/Users/gexiaolin/git/automation/payease");
        File[] listOfFiles = folder.listFiles();
        List<String> lists = List(listOfFiles).map(e -> e.getAbsolutePath());
        lists.stdout();
        List<String> res = orderIds.filter(e -> lists.filter(e1 -> e1.contains(e)).length() < 1);
        System.out.println(res);
    }


    @Test
    public void list() {
        // Tuple2,  map(), reduce(), splitAt()
        List<Tuple2<String, String>> list = List(Tuple.of("name","a"), Tuple.of("name", "b"), Tuple.of("name", "c"));
        String res = list.length() == 1 ?
                list.map(e -> e._2).reduce((pre , cur) -> pre) :
                list.length() == 2 ?
                list.map(e -> e._2).reduce((pre , cur) -> pre + " & " + cur):
                list.map(e -> e._2).splitAt(1)._1.reduce((pre, cur) -> pre )
                        + list.map(e -> e._2).splitAt(1)._2.reduce((pre, cur) -> ", " +pre + " & "+ cur);
        System.out.println(res);
    }


/*
    @Test
    public void find_the_ball() {
        int start = 0;
        int loc =  start;
        List<Tuple2<Integer,Integer>> list = List(Tuple.of(0,1),Tuple.of(1,2),Tuple.of(1,0));
        List<List<Integer>> list2 = List(List(0,1), List(1,2), List(1,0));

        Tuple res =list.reduce((pre, cur) -> pre);
        int res2 =list2.reduce((pre, cur) -> {
            if(pre.get(0).equals(loc)){
                int sec = pre.get(1);
                return sec;
            }
        });

        System.out.println(res);
        System.out.println(res2);

    }
    */


List<Integer> list1 = List.of(1,2,3);
    List<Integer> list2 = list1.tail().prepend(0);
Queue<Integer> queue = Queue.of(1);
    Option<Tuple2<Integer, Queue<Integer>>> dequeued = queue.dequeueOption();

    SortedSet<Integer> xs = TreeSet.of(6,1,2,4,3,5,8,7);

    Comparator<Integer> c = (a, b) -> b - a;


}


