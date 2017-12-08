package by.it_academy.task1;
/*       Делаем вот это задание:
     Написать простой калькулятор в консоли, который будет уметь складывать, отнимать, умножать и делить числа, и выводить результат.
     Числа вводить в консоли и проверять на корректность + проверять во время операций сложения, вычитания и тд.
     Выбор оператора (+, -  и т. д.) можно спрашивать у пользователя в виде:
     - введите 1, чтобы сложить 2 числа
     - введите 2, чтобы умножить 2 числа
     - и т. д.
     Но возможно вы сможете придумать более крутое решение по вводу данных ) это только приветствуется.*/

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        int i = 0;
        while(i == 0){
        double rez = operation();
        System.out.println("Результат операции равен " + rez);
        System.out.println("нажмине 0, чтобы выполнить еще один расчет:");
            Scanner in = new Scanner(System.in);
            i = in.nextInt();
        }
    }

    private static double input()throws IOException, InputMismatchException   { // Вместо запятой могут ввести точку, поэтому проверка на InputMismatchException
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число:");
        double num = in.nextDouble();
        return num;
    }

    private static double operation(){
        Scanner io = new Scanner(System.in);
        double num1 = 0;
        double num2 = 0;
        try {
            num1 = input();
            System.out.println("Введите 2-е число.");
            num2 = input();
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Неверный символ!");
            return 0;
    }
        System.out.println("Введите 1 для сложения\n\t\t2 для вычитания\n\t\t3 для умножения\n\t\t4 для деления");
        int flag = io.nextInt();
        double rez = 0;
        switch (flag){
            case 1:{
                rez = num1 + num2;
                break;
            }
            case 2:{
                rez = num1 - num2;
                break;
            }
            case 3:{
                rez = num1 * num2;
                break;
            }
            case 4:{
                try {
                    rez = num1 / num2;
                }catch (ArithmeticException e){
                    System.out.println(e.toString());
                }
                break;
            }
            default:{
                System.out.println("Вы ввели неправильное число");
            }
        }
        return rez;
    }
}
