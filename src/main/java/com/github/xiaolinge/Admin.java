package com.github.xiaolinge;

public class Admin extends Human {
    private Float salary;

    public void manage() {
        System.out.println("manage");
    }

    @Override
    public void walk() {
        System.out.println("admin walk");
    }
}