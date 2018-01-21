package by.it_academy.controller.interfaces;

import by.it_academy.model.parsers.ParserFactory;

public interface Manager {
    public void connect();
    public void parseFile();
    public void showAll();
    public String printCustomer(int id);
    public void searchCustomerByCar(String car);
    public void searchCustomerByName(String name);
    public void searchCustomerByBirthday();
    public void searchCustomerByLastOrder();
}
