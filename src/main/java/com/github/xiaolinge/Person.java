package com.github.xiaolinge;


import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor = "of")
@Accessors(fluent = true)
public class Person {
    private String name;
    private int age;
}

