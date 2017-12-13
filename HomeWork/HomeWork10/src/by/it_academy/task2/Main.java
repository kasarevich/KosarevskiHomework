package by.it_academy.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public  static void main(String []arg){
        List<People> manList= new ArrayList<>();
        List<People> womanList= new ArrayList<>();

        Map<String, List<People>> peopleMap = new HashMap<>();

        manList.add(new People("Путин В.В."));
        manList.add(new People("Ургант И.А."));
        manList.add(new People("Оксимирон М.Я."));

        womanList.add(new People("Поклонская Н.В."));
        womanList.add(new People("Яровая И.А."));
        womanList.add(new People("Королёва Н.П."));

        peopleMap.put("man", manList);
        peopleMap.put("woman", womanList);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        boolean ok = true;
        while (ok) {
            System.out.println("Введите \"man\", чтобы вывести на экран данные о мужчине.");
            System.out.println("Введите \"woman\", чтобы вывести на экран данные о женщине:");
            try {
                String text = reader.readLine();
                if (text.equals("man")) {
                    int index = random.nextInt(manList.size());
                    System.out.println(peopleMap.get("man").get(index));
                } else if (text.equals("woman")) {
                    int index = random.nextInt(womanList.size());
                    System.out.println(peopleMap.get("woman").get(index));
                } else
                    System.out.println("По вашему запросу данные не найдены!");

            System.out.println("Нажмите любую клавишу чтобы выйти\n 1 - продолжить");
            if(!reader.readLine().equals("1")) { ok = false; }

            } catch (IOException e) {
            System.out.println(e.toString());
            }
        }
    }
}
