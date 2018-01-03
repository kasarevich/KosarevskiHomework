package by.it_academy.data.parsers;

import by.it_academy.domain.entity.Station;
import by.it_academy.domain.interfaces.Parser;
import com.google.gson.Gson;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class JSONParser implements Parser{
    @Override
    public Station parse(String nameOfFile)throws ParserConfigurationException, FileNotFoundException,
            IOException, ParseException, Exception{

        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameOfFile));
        Station station = gson.fromJson(bufferedReader, Station.class);

        return station;
    }
}
