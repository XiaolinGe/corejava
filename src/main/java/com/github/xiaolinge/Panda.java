package com.github.xiaolinge;

public class Panda extends Animal {

    private String color;

    @Override
    public void bark() {
        System.out.println("panda bark");
    }

    @Override
    public void eat(Integer a) {
        System.out.println("animal eat: "+ a);
    }

    public void eat(Integer a, Integer b) {
        System.out.println("panda eat: " + a);
        System.out.println("panda eat: " + b);
    }
}