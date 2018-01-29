package by.it_academy.parsers;

import by.it_academy.model.entity.Station;
import com.google.gson.Gson;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class JSONParser implements ParserFactory{
    @Override
    public Station parse(String nameOfFile)throws ParserConfigurationException,
            IOException, ParseException, SAXException {

        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameOfFile));
        Station station = gson.fromJson(bufferedReader, Station.class);

        if (station == null){
            throw new SAXException("Не удалось расшифровать файл");
        }
        return station;
    }
}
