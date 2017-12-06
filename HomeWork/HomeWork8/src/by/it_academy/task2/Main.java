package by.it_academy.task2;


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

    private static double input()throws IOException, InputMismatchException { // Вместо запятой могут ввести точку, поэтому проверка на InputMismatchException
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
                rez = Operations.plus(num1, num2);
                break;
            }
            case 2:{
                rez = Operations.minus(num1, num2);
                break;
            }
            case 3:{
                rez = Operations.multiplication(num1, num2);
                break;
            }
            case 4:{
                    rez = Operations.dividing(num1, num2);
                break;
            }
            default:{
                System.out.println("Вы ввели неправильное число");
            }
        }
        return rez;
    }
}
