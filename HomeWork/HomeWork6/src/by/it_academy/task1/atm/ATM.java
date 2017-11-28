package by.it_academy.task1.atm;

import by.it_academy.task1.interfaces.AtmWithAdd;
import by.it_academy.task1.interfaces.AtmWithChange;
import by.it_academy.task1.interfaces.AtmWithDraw;

public abstract class ATM implements AtmWithAdd, AtmWithDraw, AtmWithChange {
    private String name;
    private String producer;

    public ATM(String name, String producer) {
        this.name = name;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    abstract public void toPayMobileServices(int sum);  // Пополнить счет мобильного телефона
    abstract public void toPayFines(int sum);      // Оплатить штраф
}
