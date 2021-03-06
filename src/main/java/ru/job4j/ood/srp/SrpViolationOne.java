package ru.job4j.ood.srp;

/* Представим, что данный класс принимает и сохраняет заказ*/
public class SrpViolationOne {
    public String getOrder(String order) {
        /* реализация */
        return order;
    }

    public void saveOrder(String order) {
        /* реализация */
        System.out.println("Saved");
    }
}
/* Данный класс нарушает принцип SRP, так как он содержит в себе два разных функционала (принять и сохранить заказ)
- значит у данного класса две причины измениться (1 - если надо изменить реализацию принятия заказа, 2 - если надо изменить реализацию сохранения заказа)*/
