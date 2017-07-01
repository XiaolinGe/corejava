package com.github.xiaolinge;

public class Staff extends Human {
    private Integer age;

    public void work() {
        System.out.println("work");
    }

    @Override
    public void walk() {
        System.out.println("staff walk");
    }
}
