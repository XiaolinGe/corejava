package com.github.xiaolinge;

public abstract class Human implements Sleepable {

    private Long id;

    private String  name;

    private Float weight;

    private Float height;

    public abstract void walk();

    @Override
    public void sleep() {
        System.out.println("sleep");
    }
}



