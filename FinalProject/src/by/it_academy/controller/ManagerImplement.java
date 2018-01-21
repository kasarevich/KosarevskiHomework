package by.it_academy.controller;

import by.it_academy.model.parsers.JSONParser;
import by.it_academy.model.entity.Customer;
import by.it_academy.model.entity.Station;
import by.it_academy.controller.interfaces.Manager;
import by.it_academy.model.parsers.ParserFactory;
import by.it_academy.model.parsers.XMLParser;
import by.it_academy.model.url.URLConnector;
import by.it_academy.view.UIImplement;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerImplement implements Manager{
    static Format FORMAT;
    String nameOfFile;
    String link;
    Station st;

    /**
     * Задаем формат, ссылку для скачивания и имя файла, в который сохранятся данные
     * @param format - Enum форматов(XML, JSON)
     */
    public void setFORMAT(Format format){
        this.FORMAT = format;
        if (format == Format.XML){
            this.link = "http://kiparo.ru/t/service_station.xml";
            this.nameOfFile = "customers.xml";
        }
        else {
            this.link = "http://kiparo.ru/t/service_station.json";
            this.nameOfFile = "customers.json";
        }
    }


    @Override
    public void connect(){
        URLConnector url = new URLConnector(nameOfFile); // Задаем имя файла, в который URLConnector будет сохранять данные
        try {
            url.downloadFile(link);                      //Скачиваем данные по ссылке
        }catch (MalformedInputException e){
            UIImplement.getInstance().print(e.getMessage()); // Все сообщения об ошибках выводятся пользователю через UI
        }catch (IOException e){
            UIImplement.getInstance().print(e.getMessage());
        }catch (Exception e){
            UIImplement.getInstance().print(e.getMessage());
        }
    }

    @Override
    public void parseFile(){
    try {
        ParserFactory parser;    // Объявляем парсер через интерфейс
        if(FORMAT == Format.XML) {
            parser = new XMLParser();  // инициализируем парсер экземпляром XML-парсера, либо JSON-парсера,
        }                              // в зависимости от выбора пользователя
        else {
            parser = new JSONParser();
        }

        this.st = parser.parse(nameOfFile); // далее парсим файл и получаем объект СТО

    }catch (ParserConfigurationException e){
        UIImplement.getInstance().print(e.getMessage());
    }catch (ParseException e){
        UIImplement.getInstance().print(e.getMessage());
    }catch (FileNotFoundException e){
        UIImplement.getInstance().print(e.getMessage());
    }catch (IOException e){
        UIImplement.getInstance().print(e.getMessage());
    }catch (Exception e){
        UIImplement.getInstance().print(e.getMessage());
    }
    }

    /**
     * Вывод на экран информации обо всех клиентах станции
     */
    @Override
    public void showAll(){
        UIImplement.getInstance().print("\t" + (char) 27 + "[36m" + st.getName()+ (char)27+ "[0m");   //Цвет вывода шапки
        UIImplement.getInstance().print("\t" + (char) 27 + "[36m" + st.getLocation()+ (char)27+ "[0m");
        for (int i = 0; i < st.getCustomers().size(); i++){
            UIImplement.getInstance().print(printCustomer(i));
            }
        }

    /**
     * @param id - ID Клиента, информацию о котором необходимо получить
     * @return String customerPrinter - все данные одного клиента
     */
    @Override
    public String printCustomer(int id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Customer customer = null;
        for(int i = 0; i< st.getCustomers().size(); i++){  // Прогоняем по списку еще раз, чтобы выбирать
            if(st.getCustomers().get(i).getId() == id)     // клиента не по индексу листа, а по id
                customer = st.getCustomers().get(i);
        }
        StringBuilder customerPrinter = new StringBuilder(); // Создаем Stringbuilder со всеми данными об одном клиенте
        if (customer != null){
        customerPrinter.append(String.valueOf(customer.getId()));
        customerPrinter.append(customer.getName());
        customerPrinter.append(sdf.format(customer.getDateOfBirth()));
        customerPrinter.append(sdf.format(customer.getLastOrder()));
        if(customer.isDiscount()){
            customerPrinter.append("Есть");
        }else if(!customer.isDiscount()) {
            customerPrinter.append("Нет");
        }else { customerPrinter.append("Нет информации");}
        for (String car : customer.getCars()){
            customerPrinter.append(car);
             }
        }
        return customerPrinter.toString();
    }

    @Override
    public void searchCustomerByCar(String carName){
        Pattern pattern = Pattern.compile(carName.toLowerCase()); // для поиска без учета регистра
        int counter = 0;                                          // счетчик для вывода сообщения, если ничего не найдено
        for(Customer customer : st.getCustomers()){
            for(String car : customer.getCars()){
                Matcher matcher = pattern.matcher(car.toLowerCase());
                if (matcher.find()){
                    UIImplement.getInstance().print(printCustomer(customer.getId()));
                    counter ++;
                    break; // чтобы не дублировало клиента, если у него 2 машины со схожими именами(к примеру, вводим "а",
                           // и на экран выведет 2 раза пользователя с id 1, потому что у него toyota и audi )
                }
            }
        }
        if(counter==0){UIImplement.getInstance().print("По заданным параметрам клиентов не найдено");}
    }

    /**
     * Принцип поиска похож на поиск по названию авто, но это не дублирование кода,
     * поскольку в searchCustomerByCar надо еще пробегать по ArrayList машин
     * @param name
     */
    @Override
    public void searchCustomerByName(String name){
        Pattern pattern = Pattern.compile(name.toLowerCase());
        int counter = 0;
        for(Customer customer : st.getCustomers()){
                Matcher matcher = pattern.matcher(customer.getName().toLowerCase());
                if (matcher.find()){
                    UIImplement.getInstance().print(printCustomer(customer.getId()));
                    counter ++;
                }
        }
        if(counter==0){UIImplement.getInstance().print("По заданным параметрам клиентов не найдено");}
    }

    @Override
    public void searchCustomerByBirthday(){
        Calendar calendar = new GregorianCalendar().getInstance();  // Получаем текущий месяц
        int todayMonth = calendar.get(Calendar.MONTH) + 1;
        int monthOfBirth = 13;
        int counter = 0;
        for (Customer customer : st.getCustomers()){                   // Пробегаем по всем пользователям и сравниваем
             monthOfBirth = customer.getDateOfBirth().getMonth() + 1;  // месяц рождения с текущим месяцем. Если есть совпадение,
            if(monthOfBirth == todayMonth){                            // выводим на экран информацию о пользователе
                UIImplement.getInstance().print(printCustomer(customer.getId()));
                counter ++;
            }
        }
        if (counter == 0){
            UIImplement.getInstance().print("В текущем месяце у клиентов нет Дней Рождения");
        }
    }

    @Override
    public void searchCustomerByLastOrder(){
        Calendar today = new GregorianCalendar().getInstance(); // Получаем текущую дату
        int todayMonth = today.get(Calendar.MONTH) + 1;
        int todayYear = today.get(Calendar.YEAR);
        Calendar lastOrder = new GregorianCalendar();
        int diff;                                              // разница между последним посещением и текущим месяцем
        int counter = 0;
        for (Customer customer : st.getCustomers()){
            lastOrder.setTime(customer.getLastOrder());
                int orderMonth = lastOrder.get(Calendar.MONTH)+1;
                int orderYear = lastOrder.get(Calendar.YEAR);       // Получаем месяц и год последнего посещения
                if(todayYear - orderYear > 1){
                    UIImplement.getInstance().print(printCustomer(customer.getId()));
                    counter++;
                    continue;
                }
                diff = todayMonth - orderMonth;                 // Находим разницу между текущим месяцем и месяцем последнего посещения
                if(diff < 0){
                    todayMonth += 12;
                    diff = todayMonth - orderMonth;
                    }
                    if(diff > 6){                               // Выводим на экран клиентов, которые не обращались на СТО более 6 месяцев
                        UIImplement.getInstance().print(printCustomer(customer.getId()));
                        counter++;
                }
        }
        if (counter == 0){
            UIImplement.getInstance().print("Все клиенты проходили ТО в течении последних 6 месяцев");
        }
    }

}
