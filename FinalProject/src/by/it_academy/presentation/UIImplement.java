package by.it_academy.presentation;

import by.it_academy.domain.entity.Station;
import by.it_academy.domain.interfaces.UI;
import by.it_academy.domain.Format;
import by.it_academy.domain.ManagerImplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UIImplement implements UI{
    ManagerImplement mi = new ManagerImplement();
    Format format;

    @Override
    public void download(UI ui){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для скачивания XML файла нажмите \"0\", для скачивания JSON файла нажмите \"1\":");
        try {
            int choice = Integer.parseInt(reader.readLine());
            if (choice == 0){
                format = Format.XML;
                mi.setLink("http://kiparo.ru/t/service_station.xml");
                mi.setNameOfFile("customers.xml");
                mi.connect(ui);
            }
            if (choice == 1){
                format = Format.JSON;
                mi.setLink("http://kiparo.ru/t/service_station.json");
                mi.setNameOfFile("customers.json");
                mi.connect(ui);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void parseFile(UI ui){
        System.out.println("Парсинг " + format.name() + " файла...");
        if(format == Format.XML){
            mi.parseXML(ui);
        } else {
            mi.parseJSON(ui);
        }
        System.out.println("Парсинг " + format.name() + " файла прошел успешно!");
    }

    @Override
    public void mainMenu(UI ui){
        boolean flag = true;
        while (flag) {
            System.out.println("\tВведите:" +
                    "\n\t1 - для просмотра всей информации о станции;" +
                    "\n\t2 - для поиска клиента по автомобилю;" +
                    "\n\t3 - для поиска клиента по имени, либо фамилии;" +
                    "\n\t4 - для вывода списка клиентов, с днем рождения в текущем месяце;" +
                    "\n\t5 - для вывода списка клиентов, которые более полугода не обращались на СТО;" +
                    "\n\t0 - для завершения работы.");
            int i = 0;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                i = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                ui.print(e.getMessage());
            }

            switch (i) {
                case 1: {
                    printAllCustomers(ui);
                    break;
                }
                case 2: {
                    searchByCar(ui);
                    break;
                }
                case 3: {
                    searchByName(ui);
                    break;
                }
                case 4: {
                    searchByBirthday(ui);
                    break;
                }
                case 5: {
                    searchByLastOrder(ui);
                    break;
                }
                case 0: {
                    System.out.println("Завершение работы...");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Неверный ввод!");
                    break;
                }
            }
        }
    }

    @Override
    public void printAllCustomers(UI ui){
        System.out.println("Вывод на экран всей информаци о станции:");
        printTable();
        mi.showAll(ui);
    }
    public  void printTable(){
        System.out.println((char) 27 +"[33m[id, Имя клиента, Дата рождения, Последний визит, Скидка, Список автомобилей ]"+ (char)27 + "[0m");
        //Вывод шапки таблицы желтого цвета
    }

    @Override
    public void print(String message){
        System.out.println(message);
    }

    @Override
    public void searchByCar(UI ui){
    System.out.println("\t\tВведите марку машины:");
    String carName = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            carName = reader.readLine();
        } catch (IOException e) {
            ui.print(e.getMessage());
        }
        Pattern p = Pattern.compile("^[A-za-z0-9]+\\s*[A-za-z0-9]*$"); // Только латинские буквы любого регистра, либо цифры, может быть пробел
        Matcher m = p.matcher(carName);                                // после которого может быть строка или цифра
        if(carName!=null & m.matches()) {
            mi.searchCustomerByCar(ui, carName);
        }else{
            System.out.println("Неверный ввод!");
        }
    }


    @Override
    public void searchByName(UI ui){
        System.out.println("\t\tВведите имя или фамилию клиента:");
        String name = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            name = reader.readLine();
        } catch (IOException e) {
            ui.print(e.getMessage());
        }
        Pattern p = Pattern.compile("^[A-za-z]+\\s*[A-za-z]*$"); // Только латинские буквы любого регистра, может быть пробел
        Matcher m = p.matcher(name);                                // после которого может быть строка
        if(name!=null & m.matches()) {
            mi.searchCustomerByName(ui, name);
        }else{
            System.out.println("Неверный ввод!");
        }
    }

    @Override
    public void searchByBirthday(UI ui){
        mi.searchCustomerByBirthday(ui);
    }

    @Override
    public void searchByLastOrder(UI ui){
    mi.searchCustomerByLastOrder(ui);
    }
}
