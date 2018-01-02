package by.it_academy.Parsers;

import by.it_academy.Entity.Customer;
import by.it_academy.Entity.Station;
import by.it_academy.Interfaces.Parser;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLParser implements Parser  {
    @Override
    public Station parse(String nameOfFile) throws ParserConfigurationException, IOException, SAXException{
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
        Node customerNode = customersNodeList.item(0);

        NodeList elementsNodeList = customerNode.getChildNodes(); // получаем лист клиентов
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < elementsNodeList.getLength(); i++){
            Node node = elementsNodeList.item(0);
            if (node.getNodeType()!= Node.ELEMENT_NODE){
                continue;
            }
            Element element = (Element)node;

            int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            //Date date =
        }



return null;
    }
}
