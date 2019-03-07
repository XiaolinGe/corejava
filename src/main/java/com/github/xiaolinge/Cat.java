package com.github.xiaolinge;

public class Cat extends Animal{

    private String fur;

    @Override
    public void bark() {
        System.out.println("cat bark");
    }

    @Override
    public void eat(Integer a) {
        System.out.println("animal eat: "+ a);
    }

    public void eat(Integer a, Integer b) {
        System.out.println("cat eat: "+ (a > b ? a : b));
    }
}
