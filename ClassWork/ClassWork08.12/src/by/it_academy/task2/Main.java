package by.it_academy.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] arg){
        List<Student> array = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Нажмите 1 для добавления, 2  для удаления, 3 для вывода всех");
            int num = s.nextInt();
            switch (num){
                case 1:{
                    System.out.println("Введите имя");
                    String name = s.next();
                    System.out.println("Введите возраст");
                    int age = s.nextInt();
                    array.add(new Student(name, age));
                    System.out.println("Успешно добавлено!");
                    break;
                }
                case 2:{
                    System.out.println("Введите индекс элемента");
                    int num1 = s.nextInt();
                    array.remove(num1);
                    System.out.println("Элемент удален!");
                    break;
                }
                case 3: {
                    for (int i = 0; i < array.size(); i++) {
                        System.out.println(i + ". " + array.get(i).getName() + " " + array.get(i).getAge());
                        break;
                    }
                }

                default:{
                        System.out.println("Неверный ввод, повторите");
                        break;
                    }
                }
            System.out.println("Нажмите любую клавишу, чтобы продолжить. 0 - вход");
            if (s.nextInt() == 0){
                flag = false;
            }



        }





    }
}
