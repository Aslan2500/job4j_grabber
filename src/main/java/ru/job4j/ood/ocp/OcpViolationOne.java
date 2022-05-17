package ru.job4j.ood.ocp;

import java.util.List;

public class OcpViolationOne {

    public static class Dog {
        public String eat() {
            return "eating meat";
        }
    }

    public static void main(String[] args) {
        List<Dog> dogList = List.of(new Dog(), new Dog(), new Dog());
        dogList.forEach(Dog::eat);
    }
}

/* Необходимо было создать интерфейс Animal и имплементировать его в классе Dog, так как у нас может появиться класс животного типа Deer, которое не ест мясо*/
