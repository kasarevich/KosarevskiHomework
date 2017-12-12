package by.it_academy.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String []args){
        List<String> strings = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();
        String text;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите строку для добавления или \"ё\" для выхода");
            while (!(text = reader.readLine()).equals("ё")) {
                strings.add(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        stringSet.addAll(strings);
        strings.clear();
        strings.addAll(stringSet);

        for (int i = 0; i < strings.size(); i++) {
            strings.set(i, strings.get(i).replaceAll("[aа]", ""));
        }
        System.out.println(strings.toString());
    }
}
