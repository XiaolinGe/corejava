package com.github.xiaolinge;

public abstract class Animal implements Sleepable {

    private Long id;

    private String name;

    private enum  gender {
        male, female;
    }

    private Integer age;

    public abstract  void bark();

    public abstract void eat(Integer a);

    public abstract void eat(Integer a, Integer b );

    @Override
    public void sleep() {
        System.out.println("sleep");
    }

}





































