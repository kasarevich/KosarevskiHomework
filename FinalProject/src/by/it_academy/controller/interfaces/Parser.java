package by.it_academy.controller.interfaces;

import by.it_academy.model.entity.Station;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface Parser {
    public Station parse(String nameOfFile) throws ParserConfigurationException, FileNotFoundException,
            IOException, ParseException, Exception;
}
