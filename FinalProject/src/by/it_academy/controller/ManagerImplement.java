package by.it_academy.controller;

import by.it_academy.model.parsers.JSONParser;
import by.it_academy.model.entity.Customer;
import by.it_academy.model.entity.Station;
import by.it_academy.controller.interfaces.Manager;
import by.it_academy.controller.interfaces.Parser;
import by.it_academy.controller.interfaces.URLConnection;
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
    String nameOfFile;
    String link;
    Station st = new Station();

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public void connect(){
        URLConnection url = new URLConnector(nameOfFile);
        try {
            url.downloadFile(link);
        }catch (MalformedInputException e){
            UIImplement.getInstance().print(e.getMessage());
        }catch (IOException e){
            UIImplement.getInstance().print(e.getMessage());
        }catch (Exception e){
            UIImplement.getInstance().print(e.getMessage());
        }
    }
    @Override
    public void parseXML(){
    try {
        Parser parser = new XMLParser();
        st = parser.parse(nameOfFile);
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

    @Override
    public void parseJSON(){
        try {
            Parser parser = new JSONParser();
            st = parser.parse(nameOfFile);
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

    @Override
    public void showAll(){
        UIImplement.getInstance().print("\t" + (char) 27 + "[36m" + st.getName()+ (char)27+ "[0m");   //Цвет вывода
        UIImplement.getInstance().print("\t" + (char) 27 + "[36m" + st.getLocation()+ (char)27+ "[0m");
        for (int i = 0; i < st.getCustomers().size(); i++){
            UIImplement.getInstance().print(printCustomer(i));
            }
        }

    @Override
    public String printCustomer(int id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Customer customer = null;
        for(int i = 0; i< st.getCustomers().size(); i++){  // Прогоняем по списку еще раз, чтобы выбирать
            if(st.getCustomers().get(i).getId() == id)     // клиента не по индексу листа, а по id
                customer = st.getCustomers().get(i);
        }
        List<String> customerPrinter = new ArrayList<String>(); // Создаем строковый список со всеми данными о клиенте
        if (customer != null){
        customerPrinter.add(String.valueOf(customer.getId()));
        customerPrinter.add(customer.getName());
        customerPrinter.add(sdf.format(customer.getDateOfBirth()));
        customerPrinter.add(sdf.format(customer.getLastOrder()));
        if(customer.isDiscount()){
            customerPrinter.add("Есть");
        }else if(!customer.isDiscount()) {
            customerPrinter.add("Нет");
        }else { customerPrinter.add("Нет информации");}
        for (String car : customer.getCars()){
            customerPrinter.add(car);
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
                }
            }
        }
        if(counter==0){UIImplement.getInstance().print("По заданным параметрам клиентов не найдено");}
    }


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
        Calendar calendar = new GregorianCalendar().getInstance();
        int todayMonth = calendar.get(Calendar.MONTH) + 1;
        int monthOfBirth = 13;
        int counter = 0;
        for (Customer customer : st.getCustomers()){
             monthOfBirth = customer.getDateOfBirth().getMonth() + 1;
            if(monthOfBirth == todayMonth){
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
        Calendar today = new GregorianCalendar().getInstance();
        int todayMonth = today.get(Calendar.MONTH) + 1;
        int todayYear = today.get(Calendar.YEAR);
        Calendar lastOrder = new GregorianCalendar();
        int diff;
        int counter = 0;
        for (Customer customer : st.getCustomers()){
            lastOrder.setTime(customer.getLastOrder());
                int orderMonth = lastOrder.get(Calendar.MONTH)+1;
                int orderYear = lastOrder.get(Calendar.YEAR);
                if(todayYear - orderYear > 1){
                    UIImplement.getInstance().print(printCustomer(customer.getId()));
                    counter++;
                    continue;
                }
                diff = todayMonth - orderMonth;
                if(diff < 0){
                    todayMonth += 12;
                    diff = todayMonth - orderMonth;
                    }
                    if(diff > 6){
                        UIImplement.getInstance().print(printCustomer(customer.getId()));
                        counter++;
                }
        }
        if (counter == 0){
            UIImplement.getInstance().print("Все клиенты проходили ТО в течении последних 6 месяцев");
        }
    }

}
