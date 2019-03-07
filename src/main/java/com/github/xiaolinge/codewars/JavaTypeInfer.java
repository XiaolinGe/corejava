package com.github.xiaolinge.codewars;

import java.util.ArrayList;
import java.util.List;

public class JavaTypeInfer {
    public static void main(String[] args) {
        //before java 7
        List<String> list = new ArrayList<String>(); // infer
        System.out.println(list);
    }


}
