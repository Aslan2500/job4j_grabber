package ru.job4j.ood.srp;

/* Интерфейс включает в себя методы для открытия двери машины, включения двигателя, помывки окон*/
public interface SrpViolationTwo {

    void openDoor();

    void startEngine();

    void washWindow();
}
/* Проблема заключается в том, что данный интерфейс может быть имплементирован в класс Bike, а у мотоцикла нет дверей и окон, поэтому ему не нужны методы openDoor и washWindow*/
