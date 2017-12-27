package by.it_academy.task2;

import by.it_academy.task2.Entity.Gender;
import by.it_academy.task2.Entity.People;
import by.it_academy.task2.Entity.Root;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ser.FilterProvider;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String []args)throws IOException, ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Root root = new Root();
        root.setName("Test file task2");
        root.setGender(Gender.M);
        root.setDate(sdf.parse("2016-12-18"));
        root.setPeoples(getPeoples());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(root);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.setDateFormat(sdf);
        mapper.writeValue(new File("task2.json"), root);

    }


    private static List<People> getPeoples(){
        List<People> peopleList = new ArrayList<>();
        People p = new People(0,"Ivan","Ivanov", 12,true);
        People p1 = new People(1,"Sergey","Petrov", 20,false);
        People p2 = new People(2,"Alexey","Sidorov", 42,true);
        People p3 = new People(3,"Michael","Jackson", 34,true);
        People p4 = new People(4,"Alex","Lukashenko", 235,true);
        People p5 = new People(0,"Maksim","Galkin", 21,true);

        peopleList.add(p);
        peopleList.add(p1);
        peopleList.add(p2);
        peopleList.add(p3);
        peopleList.add(p4);
        peopleList.add(p5);

        return peopleList;
    }
}
