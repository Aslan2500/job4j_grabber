package ru.job4j.ood.ocp;

public class OcpViolationThree {

    public interface Phone {
        public String playMelody();
    }

    public static class Iphone implements Phone {
        @Override
        public String playMelody() {
            return "Playing melody";
        }
    }

    public void playGame(Iphone iphone) {
        System.out.println("Playing game");
    }
}
/* В данном случае метода playGame принимает параметр не типа абстракции, это нарушает принцип ocp*/