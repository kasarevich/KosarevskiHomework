package by.it_academy;



import by.it_academy.Entity.Root;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

import static by.it_academy.URLConnecter.connect;

public class Main {
    public static void main(String [] args){
        final String LINK = "http://kiparo.ru/t/test.xml";
        String nameOfFile = new String(connect(LINK));

        Handler handler = new Handler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(nameOfFile, handler);
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (org.xml.sax.SAXException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        Root root = handler.getRoot();
        root.showAll();
        System.exit(0);
    }
}
