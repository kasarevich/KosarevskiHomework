package by.it_academy.presentation;

import by.it_academy.domain.entity.Station;
import by.it_academy.domain.interfaces.UI;
import by.it_academy.domain.Format;
import by.it_academy.domain.ManagerImplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIImplement implements UI{
    ManagerImplement mi = new ManagerImplement();

    Format format;
    Station station = new Station();

    @Override
    public void download(UI ui){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для скачивания XML файла нажмите \"0\", для скачивания JSON файла нажмите \"1\":");
        try {
            int choice = Integer.parseInt(reader.readLine());
            System.out.println(choice);
            if (choice == 0){
                format = Format.XML;
                mi.setLink("http://kiparo.ru/t/service_station.xml");
                mi.setNameOfFile("customers.xml");
                mi.connect(ui);
            }
            if (choice == 1){
                format = Format.JSON;
                mi.setLink("http://kiparo.ru/t/service_station.json");
                mi.setNameOfFile("customers.json");
                mi.connect(ui);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void parseFile(UI ui){
        System.out.println("Парсинг " + format.name() + " файла");
        if(format == Format.XML){
            station = mi.parseXML(ui);
        } else {
            station = mi.parseJSON(ui);
        }
        System.out.println("Парсинг " + format.name() + " файла прошел успешно!");
        System.out.println(station.toString());
    }

    @Override
    public void print(String message){
        System.out.println(message);
    }
}
