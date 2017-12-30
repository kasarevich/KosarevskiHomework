package by.it_academy.Manager;

import by.it_academy.Interfaces.Manager;
import by.it_academy.Interfaces.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIImplement implements UI{
    ManagerImplement mi = new ManagerImplement();
    UI ui = new UIImplement();
    Format format;

    public void download(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для скачивания XML файла нажмите \"0\", для скачивания JSON файла нажмите \"1\":");

        try {
            if (reader.readLine().equals("0")){
                format = Format.XML;
                mi.setLink("http://kiparo.ru/t/test.xml");
                mi.setNameOfFile("customers.xml");
            }
            if (reader.readLine().equals("1")){
                format = Format.JSON;
                mi.setLink("http://kiparo.ru/t/test.json");
                mi.setNameOfFile("customers.json");
            }else throw new IOException("Неверный формат!");
                mi.connect(ui);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public void parseFile(){
        System.out.println("Парсинг " + format.name() + " файла");
        if(format == Format.XML){
            mi.parseXML(ui);
        } else {
            mi.parseJSON(ui);
        }
    }

    @Override
    public void print(String message){
        System.out.println(message);
    }
}
