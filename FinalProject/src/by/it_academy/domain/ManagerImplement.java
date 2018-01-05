package by.it_academy.domain;

import by.it_academy.data.parsers.JSONParser;
import by.it_academy.domain.entity.Customer;
import by.it_academy.domain.entity.Station;
import by.it_academy.domain.interfaces.Manager;
import by.it_academy.domain.interfaces.Parser;
import by.it_academy.domain.interfaces.UI;
import by.it_academy.domain.interfaces.URLConnection;
import by.it_academy.data.parsers.XMLParser;
import by.it_academy.data.url.URLConnector;


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
    public void connect(UI ui){
        URLConnection url = new URLConnector(nameOfFile);
        try {
            url.downloadFile(link);
            ui.print("Файл успешно скачан! Название файла: " + nameOfFile);
        }catch (MalformedInputException e){
            ui.print(e.getMessage());
        }catch (IOException e){
            ui.print(e.getMessage());
        }catch (Exception e){
            ui.print(e.getMessage());
        }
    }
    @Override
    public void parseXML(UI ui){
    try {
        Parser parser = new XMLParser();
        st = parser.parse(nameOfFile);
    }catch (ParserConfigurationException e){
        ui.print(e.getMessage());
    }catch (ParseException e){
        ui.print(e.getMessage());
    }catch (FileNotFoundException e){
        ui.print(e.getMessage());
    }catch (IOException e){
        ui.print(e.getMessage());
    }catch (Exception e){
        ui.print(e.getMessage());
    }
    }

    @Override
    public void parseJSON(UI ui){
        try {
            Parser parser = new JSONParser();
            st = parser.parse(nameOfFile);
        }catch (ParserConfigurationException e){
            ui.print(e.getMessage());
        }catch (ParseException e){
            ui.print(e.getMessage());
        }catch (FileNotFoundException e){
            ui.print(e.getMessage());
        }catch (IOException e){
            ui.print(e.getMessage());
        }catch (Exception e){
            ui.print(e.getMessage());
        }
    }

    @Override
    public void showAll(UI ui){
        ui.print("\t" + (char) 27 + "[36m" + st.getName()+ (char)27+ "[0m");   //Цвет вывода
        ui.print("\t" + (char) 27 + "[36m" + st.getLocation()+ (char)27+ "[0m");
        for (int i = 0; i < st.getCustomers().size(); i++){
            ui.print(printCustomer(i));
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
    public void searchCustomerByCar(UI ui, String carName){
        Pattern pattern = Pattern.compile(carName.toLowerCase()); // для поиска без учета регистра
        int counter = 0;                                          // счетчик для вывода сообщения, если ничего не найдено
        for(Customer customer : st.getCustomers()){
            for(String car : customer.getCars()){
                Matcher matcher = pattern.matcher(car.toLowerCase());
                if (matcher.find()){
                    ui.print(printCustomer(customer.getId()));
                    counter ++;
                }
            }
        }
        if(counter==0){ui.print("По заданным параметрам клиентов не найдено");}
    }


    @Override
    public void searchCustomerByName(UI ui, String name){
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

    @Override
    public void searchCustomerByBirthday(UI ui){
        Calendar calendar = new GregorianCalendar().getInstance();
        int todayMonth = calendar.get(Calendar.MONTH) + 1;
        int monthOfBirth = 13;
        int counter = 0;
        for (Customer customer : st.getCustomers()){
             monthOfBirth = customer.getDateOfBirth().getMonth() + 1;
            if(monthOfBirth == todayMonth){
                ui.print(printCustomer(customer.getId()));
                counter ++;
            }
        }
        if (counter == 0){
            ui.print("В текущем месяце у клиентов нет Дней Рождения");
        }
    }

    @Override
    public void searchCustomerByLastOrder(UI ui){
        final long SIXMONTH = 15778800000L;
        Calendar today = new GregorianCalendar().getInstance();
        Calendar lastOrder = new GregorianCalendar();
        long diff;
        int counter = 0;
        for (Customer customer : st.getCustomers()){
            lastOrder.setTime(customer.getLastOrder());
                diff = today.getTimeInMillis() - lastOrder.getTimeInMillis();
                if (diff > SIXMONTH) {
                    ui.print(printCustomer(customer.getId()));
                    counter++;
                }
        }
        if (counter == 0){
            ui.print("Все клиенты проходили ТО в течении последних 6 месяцев");
        }
    }

}
