package by.it_academy.task2;

import java.util.Scanner;

public class Main {
    public static void main (String []args){
        Scanner io = new Scanner(System.in);
        int i = 0;
        while(i == 0) {
            Calculate calculate = new Calculate();
            input(calculate);
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
                    } catch (ArithmeticException e) {
                        System.out.println(e.toString());
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
    public static void input(Calculate calculate){
        Scanner in = new Scanner(System.in);
        double num1 = -0.56789056789; // для проверки пустой ввод, или нет(Проверка на == null не работает с double, а при приведении к Double, всегда false)
        double num2 = num1;
        try {
        System.out.println("Введите число:");
        num1 = in.nextDouble();
        System.out.println("Введите число:");
        num2 = in.nextDouble();
        /*if((num1 instanceof Double) && (num2 instanceof(double)))*/
                throw new ScannerException("Неверный формат!");
            }catch (ScannerException e){
                System.out.println(e.getRussianMessage());
            }
        calculate.setNum1(num1);
        calculate.setNum2(num2);
        }


}
