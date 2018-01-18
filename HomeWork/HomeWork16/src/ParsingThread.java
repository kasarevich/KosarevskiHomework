import com.google.gson.Gson;
import entity.Customer;
import entity.Station;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParsingThread extends Thread{
    private DownloadThread downloadThread;
    private Station stationFromXML;
    private Station stationFromJson;

    private static boolean isReady = false;


    public Station getStationFromXML() {
        return stationFromXML;
    }

    public Station getStationFromJson() {
        return stationFromJson;
    }

    public void setDownloadThread(DownloadThread downloadThread){
        this.downloadThread = downloadThread;
    }

    public static void changeReady(){
        isReady = !isReady;
    }

    @Override
    public void run() {

            System.out.println("Waiting download XML...");
            synchronized (downloadThread) {     //синхронизируемся по даунлоадеру
                try {
                    if(!isReady) {              // если файлы еще не готовы для парсинга, засыпаем
                        downloadThread.wait();  // чтобы предотвратить "вечную спячку"
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Parsing XML...");    // даунлоадер все скачал и разбудил парсер
            changeReady();                           // устанавливаем переключатель готовности в исходное положение - false
            try {
                stationFromXML = parseXML(DownloadThread.nameXML);      // парсим XML
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("The parsing is over!");
            synchronized (downloadThread) {             //парсинг окончен, будим даунлоадер
                downloadThread.notify();
            }
            synchronized (downloadThread) {
            try {
                if(!isReady) {                      // сами засыпаем, если файлы даунлоадера еще не готовы
                    downloadThread.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("Parsing JSON...");         // нас разбудили, возвращаем переключатель в исходное и парсим JSON
            changeReady();
            try {
                stationFromJson = parseJSON(DownloadThread.nameJSON);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("The parsing is over!");
            synchronized (downloadThread) {
            downloadThread.notify();                // парсинг окончен, будим даунлоадер, чтобы он сообщил об окончании программы
        }
        }


    public Station parseXML(String nameOfFile) throws Exception{
        Station station = new Station();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(nameOfFile));

        Element rootElement = doc.getDocumentElement();

        NodeList nameNodeList = rootElement.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);
        station.setName(nameNode.getTextContent());


        NodeList locationNodeList = rootElement.getElementsByTagName("location");
        Node locationNode = locationNodeList.item(0);
        station.setLocation(locationNode.getTextContent());

        NodeList customersNodeList = rootElement.getElementsByTagName("customers");
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < customersNodeList.getLength(); i++) {
            Node node = customersNodeList.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Element element = (Element) node;

            int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
            String name = element.getElementsByTagName("name").item(0).getTextContent();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String dateOfLastOrder = element.getElementsByTagName("lastOrder").item(0).getTextContent();
            Date dateOfLast = sdf.parse(dateOfLastOrder);

            String birthday = element.getElementsByTagName("dateOfBirth").item(0).getTextContent();
            Date dateOfBirth = sdf.parse(birthday);

            NodeList carNodeList = element.getElementsByTagName("car");
            List<String> cars = new ArrayList<>();
            for(int j=0; j< carNodeList.getLength(); j++){

                Node carNode = carNodeList.item(j);
                if (carNode.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                String car = carNode.getTextContent();
                cars.add(car);
            }

            Boolean isDiscount = Boolean.parseBoolean(element.getElementsByTagName("discount").item(0).getTextContent());

            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setLastOrder(dateOfLast);
            customer.setDateOfBirth(dateOfBirth);
            customer.setCars(cars);
            customer.setDiscount(isDiscount);

            customers.add(customer);
        }
        station.setCustomers(customers);
        if (station == null){
            throw new Exception("Не удалось расшифровать файл");
        }
        return station;
    }


    public Station parseJSON(String nameOfFile)throws Exception{

        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameOfFile));
        Station station = gson.fromJson(bufferedReader, Station.class);

        return station;
    }

}
