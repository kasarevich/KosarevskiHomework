package by.it_academy;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser extends DefaultHandler{
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

//            System.out.println("Тег: "+qName);
//            if(qName.equals("book"))
//                System.out.println("id книги "+attributes.getValue("id"));
//                  System.out.println(attributes.getLength());



        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        for(int i=start;i< start+length;++i)
            System.err.print(ch[i]);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Тег разобран: "+qName);
        super.endElement(uri, localName, qName);
    }


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало разбора документа!");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("Разбор документа окончен!");

    }
}
