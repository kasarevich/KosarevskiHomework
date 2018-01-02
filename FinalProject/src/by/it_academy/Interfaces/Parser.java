package by.it_academy.Interfaces;

import by.it_academy.Entity.Station;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Parser {
    public Station parse(String nameOfFile) throws ParserConfigurationException, IOException, SAXException;
}
