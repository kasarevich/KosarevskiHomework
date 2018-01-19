package by.it_academy.view;

import by.it_academy.controller.interfaces.UI;
import by.it_academy.controller.Format;
import by.it_academy.controller.ManagerImplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class UIImplement implements UI{
    private static UIImplement instance;
    ManagerImplement mi = new ManagerImplement();
    Format format;
    static volatile boolean isReady = false;            // флаг готовности скачивания и парсинга

    public void setReady(boolean instance){
        isReady = instance;
    }


    public static UIImplement getInstance(){
        if (instance == null){
            instance = new UIImplement();
        }
        return instance;
    }


    @Override
    public void downloadAndParse(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для скачивания XML файла нажмите \"0\", для скачивания JSON файла нажмите \"1\":");
        try {
            int choice = Integer.parseInt(reader.readLine());
            if (choice == 0){
                format = Format.XML;
                mi.setLink("http://kiparo.ru/t/service_station.xml");
                mi.setNameOfFile("customers.xml");
            }
            if (choice == 1) {
                format = Format.JSON;
                mi.setLink("http://kiparo.ru/t/service_station.json");
                mi.setNameOfFile("customers.json");
            }



                Thread downloading = new Thread(new Runnable() {      // Скачивание и парсинг происходят в новом потоке
                    @Override
                    public void run() {
                        mi.connect();

                        if(format == Format.XML){
                            mi.parseXML();
                        } else {
                            mi.parseJSON();
                        }

                        try {
                            Thread.sleep(4000);             // Чтобы была видна анимация загрузки) быстро качает и парсит
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        UIImplement.getInstance().setReady(true);
                    }
                });



            downloading.start();


            System.out.println("Ожидание скачивания и парсинга...");


            while(!isReady) {
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(500);
                }
                for (int i = 0; i < 3; i++) {
                    System.out.print("\r");
                    Thread.sleep(500);
                }

            }
            setReady(false);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void mainMenu(){
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
                print(e.getMessage());
            }

            switch (i) {
                case 1: {
                    printAllCustomers();
                    break;
                }
                case 2: {
                    searchByCar();
                    break;
                }
                case 3: {
                    searchByName();
                    break;
                }
                case 4: {
                    searchByBirthday();
                    break;
                }
                case 5: {
                    searchByLastOrder();
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
    public void printAllCustomers(){
        System.out.println("Вывод на экран всей информаци о станции:");
        printTable();
        mi.showAll();
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
    public void searchByCar(){
    System.out.println("\t\tВведите марку машины:");
    String carName = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            carName = reader.readLine();
        } catch (IOException e) {
            print(e.getMessage());
        }
        Pattern p = Pattern.compile("^[A-za-z0-9]+\\s*[A-za-z0-9]*$"); // Только латинские буквы любого регистра, либо цифры, может быть пробел
        Matcher m = p.matcher(carName);                                // после которого может быть строка или цифра
        if(carName!=null & m.matches()) {
            mi.searchCustomerByCar(carName);
        }else{
            System.out.println("Неверный ввод!");
        }
    }


    @Override
    public void searchByName(){
        System.out.println("\t\tВведите имя или фамилию клиента:");
        String name = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            name = reader.readLine();
        } catch (IOException e) {
            print(e.getMessage());
        }
        Pattern p = Pattern.compile("^[A-za-z]+\\s*[A-za-z]*$"); // Только латинские буквы любого регистра, может быть пробел
        Matcher m = p.matcher(name);                                // после которого может быть строка
        if(name!=null & m.matches()) {
            mi.searchCustomerByName(name);
        }else{
            System.out.println("Неверный ввод!");
        }
    }

    @Override
    public void searchByBirthday(){
        mi.searchCustomerByBirthday();
    }

    @Override
    public void searchByLastOrder(){
    mi.searchCustomerByLastOrder();
    }
}
