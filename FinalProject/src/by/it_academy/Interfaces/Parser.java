package by.it_academy.interfaces;

import by.it_academy.entity.Station;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public interface Parser {
    public Station parse(String nameOfFile) throws ParserConfigurationException,
            IOException, ParseException, Exception;
}
