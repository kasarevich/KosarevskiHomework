package by.it_academy.domain.interfaces;

import by.it_academy.domain.entity.Station;

public interface Manager {
    public void connect(UI ui);
    public void parseXML(UI ui);
    public void parseJSON(UI ui);
    public void showAll(UI ui);
    public String printCustomer(int id);
    public void searchCustomerByCar(UI ui, String car);
    public void searchCustomerByName(UI ui, String name);
    public void searchCustomerByBirthday(UI ui);
    public void searchCustomerByLastOrder(UI ui);
}
