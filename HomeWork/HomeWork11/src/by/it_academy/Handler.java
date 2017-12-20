package by.it_academy;

import by.it_academy.Entity.People;
import by.it_academy.Entity.Root;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {
    private Root root;
    private String element;
    private People people;
    private boolean isNameOfRoot;
    private boolean isStart;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start parsing...");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end parsing...");
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isStart = true;
        element = qName;
        if(element.equals("root")){
            root = new Root();
            isNameOfRoot = true;
        }else if (qName.equals("people")){
            root.setPeoples(new ArrayList<>());
            isNameOfRoot = false;
        } else if (qName.equals("element")){
            people = new People();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isStart = false;
        if (qName.equals("element")){
            root.getPeoples().add(people);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isStart) {
            if (element.equals("name")) {
                if (isNameOfRoot) {
                    root.setName(new String(ch, start, length));
                } else {
                    people.setName(new String(ch, start, length));
                }
            }else if(element.equals("surname")) {people.setSurname(new String(ch, start, length));
            }else if(element.equals("id")){ people.setId(Integer.parseInt(new String(ch, start, length)));
            }else if(element.equals("age")){people.setAge(Integer.parseInt(new String(ch, start, length)));
            }else if(element.equals("isDegree")){people.setDegree(Boolean.getBoolean(new String(ch, start, length)));
            }
            }
    }
    public Root getRoot(){
        return root;
    }
}
