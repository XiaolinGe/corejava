package com.github.xiaolinge;

import java.util.ArrayList;
import java.util.List;


public class TestAnimal {
    public static void main(String[] args) {
        Animal cat1 = new Cat();
        Animal cat2 = new Cat();
        Animal dog1 = new Dog();
        Animal dog2 = new Dog();
        Animal panda1 = new Panda();
        Animal panda2 = new Panda();

        cat1.sleep();


        List<Animal> animals = new ArrayList<>();

        animals.add(cat1);
        animals.add(cat2);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(panda1);
        animals.add(panda2);

    for(Animal animal : animals) {
        animal.bark();
        animal.eat(1,2);
        animal.sleep();

        System.out.println(animal instanceof Cat);
    }

    }
}

