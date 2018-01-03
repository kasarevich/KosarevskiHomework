package by.it_academy;

import org.junit.runners.JUnit4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String [] args){
        String text = "@afdj@gmail.com@";
        text = text.replaceAll("^@|@$", "");// удаление подстроки через "или"
        System.out.println(text);

        String number = "4545 ПД-5";
        Pattern pattern = Pattern.compile("\\d{4} [А-Я]{2}-[1-7]"); //(^[0-9]{4} [А-Яа-я]{2}-[1-7]{1}$)
        Matcher matcher = pattern.matcher(number);

        if(matcher.matches()){
            System.out.println("Номер корректный");
        }else {
            System.out.println("Номер некорректный");
        }

        String phoneNumder = "+375(25)9717199";
        System.out.println(phoneNumder);
        phoneNumder = phoneNumder.replaceAll("\\D", ""); //Удаляем все, что не является цифрами
        System.out.println(phoneNumder);
        Pattern pattern1 = Pattern.compile("^375(17|29|44|33|25)\\d{7}$");
        Matcher matcher1 = pattern1.matcher(phoneNumder);

        if(matcher1.matches()){
            System.out.println("Номер белорусский");
        }else {
            System.out.println("Номер заморский");
        }

    }

    public static boolean checkCarNumber(String text){
        Pattern pattern = Pattern.compile("\\d{4} [А-Я]{2}-[1-7]");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();

    }

    public static boolean checkPhoneNumber(String text){
        text = text.replaceAll("\\D", "");
        Pattern pattern = Pattern.compile("^375(17|29|44|33|25)\\d{7}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
