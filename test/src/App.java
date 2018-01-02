import entity.Car;
import entity.Customer;
import entity.Station;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    final static String NameOfFile = "test.xml";
    final static String LINK = "http://kiparo.ru/t/service_station.xml";
    public static void main(String[] args) {
        try {
            downloadFile();
            Station station = parse();
            System.out.println(station.toString());
        }catch (MalformedInputException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (SAXException e){
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Station parse() throws ParserConfigurationException, IOException, SAXException, ParseException{
        Station station = new Station();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(NameOfFile));

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
            List<Car> cars = new ArrayList<>();
                for(int j=0; j< carNodeList.getLength(); j++){

                    Node carNode = carNodeList.item(j);
                    if (carNode.getNodeType() != Node.ELEMENT_NODE) {
                        continue;
                    }
                    String carName = carNode.getTextContent();
                    Car car = new Car();
                    car.setName(carName);
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
        return station;
    }



    public static void downloadFile() throws MalformedInputException, IOException, Exception{
        URL url = new URL(LINK);
        HttpURLConnection httpURLConnection =
                (HttpURLConnection) url.openConnection();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            InputStream inputStream = httpURLConnection.getInputStream();
            File file = new File(NameOfFile);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int byteRead = -1;
            byte[] buffer = new byte[2048];
            while ((byteRead = inputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0, byteRead);
            }
        }else {
            throw new Exception("Данные не найдены, response code = " + responseCode);
        }
    }
}

