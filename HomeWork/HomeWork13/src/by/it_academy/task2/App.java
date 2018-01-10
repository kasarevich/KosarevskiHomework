package by.it_academy.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[]args){
            String str[] =  new String[]{"ygigkuih/jhgk/uyyuj.hvfhjbevh.xml", "dghsgdj.asda.doc" , "ahfk@doctor", "students.json"};
            for (String string: str){
                printFormat(string);
            }
        }

    public static void printFormat(String str) {
        Pattern pattern = Pattern.compile("\\.[\\w]+$");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String format = matcher.group().substring(1);
            System.out.println(format);
        }
        else System.out.println("Формат неизвестен!");
    }
}
