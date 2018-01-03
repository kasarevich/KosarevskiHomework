package by.it_academy.manager;

import by.it_academy.entity.Station;
import by.it_academy.interfaces.UI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIImplement implements UI{
    ManagerImplement mi = new ManagerImplement();
    UI ui = new UIImplement();
    Format format;
    Station station = new Station();

    @Override
    public void download(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для скачивания XML файла нажмите \"0\", для скачивания JSON файла нажмите \"1\":");

        try {
            if (reader.readLine().equals("0")){
                format = Format.XML;
                mi.setLink("http://kiparo.ru/t/service_station.xml");
                mi.setNameOfFile("customers.xml");
            }
            if (reader.readLine().equals("1")){
                format = Format.JSON;
                mi.setLink("http://kiparo.ru/t/service_station.json");
                mi.setNameOfFile("customers.json");
            }else throw new IOException("Неверный формат!");
                mi.connect(ui);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void parseFile(){
        System.out.println("Парсинг " + format.name() + " файла");
        if(format == Format.XML){
            station = mi.parseXML(ui);
        } else {
            station = mi.parseJSON(ui);
        }
    }

    @Override
    public void print(String message){
        System.out.println(message);
    }
}
