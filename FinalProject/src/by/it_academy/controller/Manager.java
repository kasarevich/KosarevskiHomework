package by.it_academy.controller;

import by.it_academy.model.entity.Customer;
import by.it_academy.model.entity.Station;
import by.it_academy.parsers.JSONParser;
import by.it_academy.parsers.ParserFactory;
import by.it_academy.parsers.XMLParser;
import by.it_academy.url.URLConnector;
import by.it_academy.view.UI;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager{
    private static Manager instance;

    static Format FORMAT;
    private UI ui; // С UI взаимодействуем через интерфейс(если UI будет другим, все
    // эти же методы он должен реализовывать и нам не важно, какой именно интерфейс)
    private String nameOfFile;
    private String link;
    private Station st;

    public static synchronized Manager getInstance(){ // Singleton
        if (instance == null){
            instance = new Manager();
        }
        return instance;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

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


    public void connect() throws IOException{
        URLConnector url = new URLConnector(nameOfFile); // Задаем имя файла, в который URLConnector будет сохранять данные
        try {
            url.downloadFile(link);                      //Скачиваем данные по ссылке
        }catch (MalformedInputException e){
            ui.print(e.getMessage()); // Все сообщения об ошибках выводятся пользователю через UI
        }
    }


    public void parseFile() throws SAXException{
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
            ui.print(e.getMessage());
        }catch (ParseException e){
            ui.print(e.getMessage());
        }catch (FileNotFoundException e){
            ui.print(e.getMessage());
        }catch (IOException e){
            ui.print(e.getMessage());
        }
    }

    /**
     * Вывод на экран информации обо всех клиентах станции
     */

    public void showAll(){
        ui.print("\t" + (char) 27 + "[36m" + st.getName()+ (char)27+ "[0m");   //Цвет вывода шапки
        ui.print("\t" + (char) 27 + "[36m" + st.getLocation()+ (char)27+ "[0m");
        for (int i = 0; i < st.getCustomers().size(); i++){
            ui.print(printCustomer(i));
        }
    }

    /**
     * @param id - ID Клиента, информацию о котором необходимо получить
     * @return String customerPrinter - все данные одного клиента
     */

    public String printCustomer(int id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Customer customer = null;
        for(int i = 0; i< st.getCustomers().size(); i++){  // Прогоняем по списку еще раз, чтобы выбирать
            if(st.getCustomers().get(i).getId() == id)     // клиента не по индексу листа, а по id
                customer = st.getCustomers().get(i);
        }
        StringBuilder customerPrinter = new StringBuilder(); // Создаем Stringbuilder со всеми данными об одном клиенте
        if (customer != null){
            customerPrinter.append(String.valueOf(customer.getId()) + "\t");
            customerPrinter.append(customer.getName() + " ");
            customerPrinter.append(sdf.format(customer.getDateOfBirth()) + " ");
            customerPrinter.append(sdf.format(customer.getLastOrder()) + " ");
            if(customer.isDiscount()){
                customerPrinter.append("Есть" + " ");
            }else if(!customer.isDiscount()) {
                customerPrinter.append("Нет" + " ");
            }else { customerPrinter.append("Нет информации" + " ");}
            for (String car : customer.getCars()){
                customerPrinter.append(car + ", ");
            }
        }
        return customerPrinter.toString();
    }


    public void searchCustomerByCar(String carName){
        Pattern pattern = Pattern.compile(carName.toLowerCase()); // для поиска без учета регистра
        int counter = 0;                                          // счетчик для вывода сообщения, если ничего не найдено
        for(Customer customer : st.getCustomers()){
            for(String car : customer.getCars()){
                Matcher matcher = pattern.matcher(car.toLowerCase());
                if (matcher.find()){
                    ui.print(printCustomer(customer.getId()));
                    counter ++;
                    break; // чтобы не дублировало клиента, если у него 2 машины со схожими именами(к примеру, вводим "а",
                    // и на экран выведет 2 раза пользователя с id 1, потому что у него toyota и audi )
                }
            }
        }
        if(counter==0){ui.print("По заданным параметрам клиентов не найдено");}
    }

    /**
     * Принцип поиска похож на поиск по названию авто, но это не дублирование кода,
     * поскольку в searchCustomerByCar надо еще пробегать по ArrayList машин
     * @param name
     */

    public void searchCustomerByName(String name){
        Pattern pattern = Pattern.compile(name.toLowerCase());
        int counter = 0;
        for(Customer customer : st.getCustomers()){
            Matcher matcher = pattern.matcher(customer.getName().toLowerCase());
            if (matcher.find()){
                ui.print(printCustomer(customer.getId()));
                counter ++;
            }
        }
        if(counter==0){ui.print("По заданным параметрам клиентов не найдено");}
    }


    public void searchCustomerByBirthday(){
        Calendar calendar = new GregorianCalendar().getInstance();  // Получаем текущий месяц
        int todayMonth = calendar.get(Calendar.MONTH) + 1;
        int monthOfBirth = 13;
        int counter = 0;
        for (Customer customer : st.getCustomers()){                   // Пробегаем по всем пользователям и сравниваем
            monthOfBirth = customer.getDateOfBirth().getMonth() + 1;  // месяц рождения с текущим месяцем. Если есть совпадение,
            if(monthOfBirth == todayMonth){                            // выводим на экран информацию о пользователе
                ui.print(printCustomer(customer.getId()));
                counter ++;
            }
        }
        if (counter == 0){
            ui.print("В текущем месяце у клиентов нет Дней Рождения");
        }
    }

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
                ui.print(printCustomer(customer.getId()));
                counter++;
                continue;
            }
            diff = todayMonth - orderMonth;                 // Находим разницу между текущим месяцем и месяцем последнего посещения
            if(diff < 0){
                todayMonth += 12;
                diff = todayMonth - orderMonth;
            }
            if(diff > 6){                               // Выводим на экран клиентов, которые не обращались на СТО более 6 месяцев
                ui.print(printCustomer(customer.getId()));
                counter++;
            }
        }
        if (counter == 0){
            ui.print("Все клиенты проходили ТО в течении последних 6 месяцев");
        }
    }
}

