package by.it_academy.domain.interfaces;

import by.it_academy.domain.entity.Station;

public interface Manager {
    public void connect();
    public void parseXML();
    public void parseJSON();
    public void showAll();
    public String printCustomer(int id);
    public void searchCustomerByCar(String car);
    public void searchCustomerByName(String name);
    public void searchCustomerByBirthday();
    public void searchCustomerByLastOrder();
}
