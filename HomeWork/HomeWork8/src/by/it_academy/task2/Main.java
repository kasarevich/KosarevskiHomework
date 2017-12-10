package by.it_academy.task2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String []args){
        Scanner io = new Scanner(System.in);
        int i = 0;
        while(i == 0) {
            Calculate calculate = new Calculate();
            try {
                input(calculate);                                      // Вывод собственного исключения пустого ввода
            } catch (ScannerException e){
                System.out.println(e.getRussianMessage());
            }
            System.out.println("Введите 1 для сложения\n\t\t2 для вычитания\n\t\t3 для умножения\n\t\t4 для деления");
            int flag = io.nextInt();
            double rez = 0;
            switch (flag) {
                case 1: {
                    rez = calculate.plus();
                    break;
                }
                case 2: {
                    rez = calculate.minus();
                    break;
                }
                case 3: {
                    rez = calculate.multiplication();
                    break;
                }
                case 4: {
                    try {
                        rez = calculate.deviding();
                    } catch (DevideByZeroException e) {                                                                 // Выыод собственного исключения деления на ноль
                        System.out.println(e.getRussianMessage());
                    }
                    break;
                }
                default: {
                    System.out.println("Вы ввели неправильное число");
                }
            }
                System.out.println("Результат операции равен " + rez);
                System.out.println("нажмине 0, чтобы выполнить еще один расчет:");
                i = io.nextInt();
        }
    }
    public static void input(Calculate calculate)throws InputMismatchException{
        Scanner in = new Scanner(System.in);
        double num1 = 0;
        double num2 = 0;
        try {
        System.out.println("Введите число:");
        num1 = in.nextDouble();
        System.out.println("Введите число:");
        num2 = in.nextDouble();
            }catch (InputMismatchException e){
                throw new ScannerException("Вы ничего не ввели!");
            }
        calculate.setNum1(num1);
        calculate.setNum2(num2);
        }


}
