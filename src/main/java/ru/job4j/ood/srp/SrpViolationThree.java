package ru.job4j.ood.srp;

public final class SrpViolationThree {
    private static SrpViolationThree instance;
    private String info = "Initial info class";

    private SrpViolationThree() {
    }

    public static SrpViolationThree getInstance() {
        if (instance == null) {
            instance = new SrpViolationThree();
        }

        return instance;
    }

}
/*Singleton нарушает принцип srp, так как класс помимо реализации каких-нибудь методов также занимается контролем количества экземпляров*/