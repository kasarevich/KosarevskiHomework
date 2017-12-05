package by.it_academy.task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static public void main(String []arg){
        ArrayList<Student> students = new ArrayList();
        byte f = 0;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Нажмите 1 для ввода нового студента\nНажмите 2 для просмотра всех студентов\nНажмите 3 для вывода среднего возраста всех студентов");
            int num = in.nextInt();
            switch (num){
                case 1:{
                    students.add(Manager.input());
                    break;
                }
                case 2:{
                       Manager.print(students);
                       break;

                }
                case 3:{
                    Manager.search(students);
                    break;
                    }
            }

        }while(f == 0);
    }
}
