package by.it_academy.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App {
    public static void main(String []args){
        String text = "aallwoorld";
        System.out.println(testString(text));
        //checkWithRegex(text);
    }
    public static boolean testString(String text){


        return false;
    }
  /*  public static void checkWithRegex(String text){
        Pattern p = Pattern.compile("([a-z]{2})");
        Matcher m = p.matcher(text);
        Map<String, Integer> repite = new HashMap();
        char [] chars = text.toCharArray();//hhhhellowooorld
        for(int i = 1; i<chars.length; i++){
            int counter = 1;
            char testChar = chars[i];
            for (int j = i; j<chars.length; j++){
                if((chars[j]==chars[j+1])&(chars[j]==testChar)){
                    testChar = chars[j];
                    counter++;
                }
            }
            if (counter>1){

        repite.put(testChar*counter, counter);
            }
        }
    }*/
}
