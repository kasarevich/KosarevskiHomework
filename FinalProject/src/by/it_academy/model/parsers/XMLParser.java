package by.it_academy.model.parsers;

import by.it_academy.model.entity.Customer;
import by.it_academy.model.entity.Station;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLParser implements ParserFactory {
    @Override
    public Station parse(String nameOfFile) throws ParserConfigurationException, IOException,
            ParseException, SAXException {
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
            throw new SAXException("Не удалось расшифровать файл");
        }
        return station;
    }
}
