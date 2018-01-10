package by.it_academy.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App {
    public static void main(String []args){
        String [] str = new String[]{ "oooooo makarenaaaa", "demobilizaciaaa ooooooo", "ooooh raaanooo! vstaet ohranaa!" };
        for(int i = 0; i < str.length; i++){
            System.out.println("string " + (i+1) + " = " + str[i]);
            System.out.print("trimmed string " + (i+1) + " = ");
            trimmer(str[i]);
        }

    }

    public static void trimmer(String s) {
        Pattern pattern = Pattern.compile("(.)\\1+");
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder(s);
        int counter = 0;
        while (matcher.find()) {
            sb.replace(matcher.start() + 1 - counter, matcher.end() - counter, String.valueOf(matcher.end() - matcher.start()));
            counter += matcher.end() - matcher.start() - 2;
        }
        System.out.println(sb);
    }
}
