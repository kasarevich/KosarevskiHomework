package by.it_academy.task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static public void main(String []arg)throws IOException{
        ArrayList<Student> students = new ArrayList();
        byte f = 0;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Нажмите 1 для просмотра всех студентов в файле.\nНажмите 2 для просмотра всех студентов в массиве.");
            int num = in.nextInt();
            switch (num){
                case 1:{

                    Manager.printFile(students);
                    break;
                }
                case 2:{
                    Manager.showArray(students);
                    break;

                }
                default:
                    break;
            }

        }while(f == 0);
    }
}
