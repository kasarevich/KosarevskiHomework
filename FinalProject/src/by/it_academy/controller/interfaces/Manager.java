package by.it_academy.controller.interfaces;

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
