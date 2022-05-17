package ru.job4j.ood.ocp;

public class OcpViolationTwo {

    public interface Animal {
        public void eat();
    }

    public static class Dog implements Animal {
        @Override
        public void eat() {
            System.out.println("Eating...");
        }
    }

    public static class Zoo {
        Dog dog = new Dog();

        public void jump(Animal animal) {
            System.out.println("jump");
        }
    }
}

/* В данном случае поле не представляет тип абстракции (Animal), это является нарушением принципа ocp*/
