package by.it_academy.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String []arg) {
        try {
            // блок catch выполнится тогда, когда произойдет проблема
            SimpleDateFormat sdf = new SimpleDateFormat("");
            int a = 5 / 0;
            System.out.println(a);
            Date date = sdf.parse("sfsdvnbvmb");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка null " + e.toString());
        } catch (ParseException e) {
            System.out.println("Ошибка date");
        } catch (Exception e) {
            System.out.println("Ошибка");
        } finally {
            System.out.println("finally");
        }
        System.out.println("Программа продолжает выполняться");


        try {
            double rez = test(5, 0);
        }catch (ArithmeticException e){
            System.out.println("Oшибка формата");
        }


        try {                                                               // Создание своих эксепшнов
            double rez = test2(5, 0);
        }catch (FiveException e){
            System.out.println("5 запрещено");
        }catch (ArithmeticException e){
            System.out.println("Oшибка формата");
        }


        }


    public static double test(int a, int b) throws ArithmeticException{
        return a/b;
    }

    public static double test2(int a, int b)throws FiveException, ArithmeticException{
       if (b == 5){
           throw new FiveException();
       }
       return a/b;
    }

}
