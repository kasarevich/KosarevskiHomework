package by.it_academy.domain;

import by.it_academy.data.parsers.JSONParser;
import by.it_academy.domain.entity.Station;
import by.it_academy.domain.interfaces.Manager;
import by.it_academy.domain.interfaces.Parser;
import by.it_academy.domain.interfaces.UI;
import by.it_academy.domain.interfaces.URLConnection;
import by.it_academy.data.parsers.XMLParser;
import by.it_academy.data.url.URLConnector;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;

public class ManagerImplement implements Manager{
    String nameOfFile;
    String link;
    Station station;

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public void connect(UI ui){
        URLConnection url = new URLConnector(nameOfFile);
        try {
            url.downloadFile(link);
            ui.print("Файл успешно скачан! Название файла: " + nameOfFile);
        }catch (MalformedInputException e){
            ui.print(e.getMessage());
        }catch (IOException e){
            ui.print(e.getMessage());
        }catch (Exception e){
            ui.print(e.getMessage());
        }
    }
    @Override
    public Station parseXML(UI ui){
        Station st = new Station();
    try {
        Parser parser = new XMLParser();
        st = parser.parse(nameOfFile);

    }catch (ParserConfigurationException e){
        ui.print(e.getMessage());
    }catch (ParseException e){
        ui.print(e.getMessage());
    }catch (FileNotFoundException e){
        ui.print(e.getMessage());
    }catch (IOException e){
        ui.print(e.getMessage());
    }catch (Exception e){
        ui.print(e.getMessage());
    }
    return st;
    }

    @Override
    public Station parseJSON(UI ui){
        Station st = new Station();
        try {
            Parser parser = new JSONParser();
            st = parser.parse(nameOfFile);
        }catch (ParserConfigurationException e){
            ui.print(e.getMessage());
        }catch (ParseException e){
            ui.print(e.getMessage());
        }catch (FileNotFoundException e){
            ui.print(e.getMessage());
        }catch (IOException e){
            ui.print(e.getMessage());
        }catch (Exception e){
            ui.print(e.getMessage());
        }
        return st;
    }


}
