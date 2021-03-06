import entity.Customer;
import entity.Station;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

            DownloadThread downloadThread = new DownloadThread();
            ParsingThread parsingThread = new ParsingThread();
            parsingThread.setDownloadThread(downloadThread);        // в парсер передаем даунлоадер, по нему будет синхронизация
            parsingThread.start();
            downloadThread.start();

            try {
                downloadThread.join();                              // поскольку даунлоадер гарантированно последним окончит работу, ожидаем его завершения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Print result of XML parsing:");       // выводим на экран результаты парсинга
            showAll(parsingThread.getStationFromXML());

            System.out.println("Print result of JSON parsing:");
            showAll(parsingThread.getStationFromJson());


    }


    public static void showAll(Station st){
        System.out.println("\t" + (char) 27 + "[36m" + st.getName()+ (char)27+ "[0m");   //Цвет вывода
        System.out.println("\t" + (char) 27 + "[36m" + st.getLocation()+ (char)27+ "[0m");
        for (int i = 0; i < st.getCustomers().size(); i++){
            System.out.println(printCustomer(st, i));
        }
    }
    public static String printCustomer(Station st, int id){
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
}