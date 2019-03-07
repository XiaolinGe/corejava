package com.github.xiaolinge;

public class Dog extends Animal {

    private String type;

    @Override
    public void bark() {
        System.out.println("dog bark");
    }

    @Override
    public void eat(Integer a) {
        System.out.println("animal eat: "+ a);
    }

    public void eat(Integer a, Integer b) {
        System.out.println("dog eat: " + (a < b ? a : b));
    }
}