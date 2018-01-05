package by.it_academy.domain.interfaces;

public interface UI {
    public void download(UI ui);
    public void parseFile(UI ui);
    public void mainMenu(UI ui);
    public void printAllCustomers(UI ui);
    public void print(String mesage);
    public void searchByCar(UI ui);
    public void searchByName(UI ui);
    public void searchByBirthday(UI ui);
    public void searchByLastOrder(UI ui);
}
