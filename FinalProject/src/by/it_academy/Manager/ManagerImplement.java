package by.it_academy.Manager;

import by.it_academy.Interfaces.Manager;
import by.it_academy.Interfaces.UI;
import by.it_academy.Interfaces.URLConnection;
import by.it_academy.URL.URLConnector;

import java.io.IOException;
import java.nio.charset.MalformedInputException;

public class ManagerImplement implements Manager{
    String nameOfFile;
    String link;

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
            ui.print("Файл успешно скачан! Имя файла: " + nameOfFile);
        }catch (MalformedInputException e){
            ui.print(e.getMessage());
        }catch (IOException e){
            ui.print(e.getMessage());
        }catch (Exception e){
            ui.print(e.getMessage());
        }
    }
    @Override
    public void parseXML(UI ui){

    }

    @Override
    public void parseJSON(UI ui){

    }


}
