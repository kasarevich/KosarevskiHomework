package by.it_academy.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[]args){
getFormat("jgkhg.xml");
    }
    public static String getFormat(String name){
        Pattern p = Pattern.compile(".+\\.(xml|json|doc|jar|html)&");
        Matcher m = p.matcher(name);
        System.out.println(p);

        return null;
    }
}
