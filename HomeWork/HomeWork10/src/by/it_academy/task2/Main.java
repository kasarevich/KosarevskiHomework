package by.it_academy.task2;

import java.util.*;

public class Main {
    public  static void main(String []arg){
        List<People> manList= new ArrayList<>();
        List<People> womanList= new ArrayList<>();

        Map<String, People> peopleMap = new HashMap<>();

        manList.add(new People("Путин В.В."));
        manList.add(new People("Ургант И.А."));
        manList.add(new People("Оксимирон М.Я."));

        womanList.add(new People("Поклонская Н.В."));
        womanList.add(new People("Яровая И.А."));
        womanList.add(new People("Королёва Н.П."));

        System.out.println(manList.toString());
        System.out.println(womanList.toString());

        for(People m : manList){
            peopleMap.put("man", m);
        }
        for(People w : womanList){
            peopleMap.put("man", w);
        }

    }
}
