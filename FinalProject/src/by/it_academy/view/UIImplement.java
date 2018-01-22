package by.it_academy.view;

import by.it_academy.controller.ManagerImplement;
import by.it_academy.controller.Format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UIImplement - пользовательский интерфейс.
 * Взаимодействие с пользователем происходит только в этом классе.
 * В зависимости от действий пользователя, реализует бизнес-логику управляя классом ManagerImplement
 */

public final class UIImplement implements UI{
    private static UIImplement instance;       // Реализация паттерна Singleton
    ManagerImplement mi = new ManagerImplement();

    private static volatile boolean isReady = false;            // флаг готовности скачивания и парсинга

    public static synchronized UIImplement getInstance(){
        if (instance == null){
            instance = new UIImplement();
        }
        return instance;
    }

    /**
     * downloadAndParse предлагает пользователю выбрать XML или JSON файл нужно скачивать
     * после выбора в новом потоке происходит скачивание и парсинг файла, а в текущем потоке
     * показывает анимацию загрузки
     */
    @Override
    public void downloadAndParse(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для скачивания XML файла нажмите \"0\", для скачивания JSON файла нажмите \"1\":");
        try {
            int choice = Integer.parseInt(reader.readLine()); //в зависимости от выбора пользователя
            if (choice == 0){                                 //устанавливаем в менеджере ссылку и имя файла(XML либо JSON)
                mi.setFORMAT(Format.XML);
            }
            if (choice == 1) {
                mi.setFORMAT(Format.JSON);
            }

                Thread downloading = new Thread(new Runnable() {      // Скачивание и парсинг происходят в новом потоке
                    @Override
                    public void run() {
                        mi.connect();
                        mi.parseFile();

                        try {
                            Thread.sleep(5000);             // Чтобы была видна анимация загрузки) потому что быстро качает и парсит
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        isReady = true;                          // меняем флаг готовности загрузузки
                    }
                });

            downloading.start();

            System.out.println("Ожидание скачивания и парсинга");

            while(!isReady) {                                   // пока поток парсинга не изменил флаг, на экран выводит анимацию
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(500);
                }
                for (int i = 0; i < 3; i++) {
                    System.out.print("\r");
                    Thread.sleep(500);
                }
            }
            isReady = false;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * mainMenu - выводит на экран главное меню, в котором пользователь может выбрать дальнейшие действия
     */
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


    /**
     *  @param message - вывод на экран сообщений из менеджера(чтобы ошибки, появляющиеся на уровне модели
     *               обрабатывалися в менеджере и оттуда через UI выводились пользователю на экран)
     */
    @Override
    public void print(String message){
        System.out.println(message);
    }

    /**
     * searchByCar() - поиск клиента по названию автомобиля
     */
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
        // Проверка корректности запроса поиска
        Pattern p = Pattern.compile("^[A-za-z0-9]+\\s*[A-za-z0-9]*$"); // Только латинские буквы любого регистра, либо цифры, может быть пробел
        Matcher m = p.matcher(carName);                                // после которого может быть строка или цифра
        if(carName!=null & m.matches()) {
            mi.searchCustomerByCar(carName);
        }else{
            System.out.println("Неверный ввод!");
        }
    }

    /**
     * searchByName() - поиск клиента по имени
     */
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
        // Проверка корректности запроса поиска
        Pattern p = Pattern.compile("^[A-za-z]+\\s*[A-za-z]*$"); // Только латинские буквы любого регистра, может быть пробел
        Matcher m = p.matcher(name);                             // после которого может быть строка
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
