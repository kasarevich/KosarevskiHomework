package by.it_academy.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static public void main(String[] arg) throws IOException {
        ArrayList<Student> students = new ArrayList();
        File file = new File("Students.txt");
           if (file.length() == 0) {
                System.out.println("Файл пуст! Добавьте студентов.");
                try {
                    Manager.input(file, true);
                } catch (IOException e) {
                    System.out.println(e.toString());
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
            try {
                Manager.read(file, students);
            } catch (IOException e) {
                System.out.println(e.toString());
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("Элементы добавлены в массив.");
            }
            System.out.println("Вывод на экран всех студентов:");
            Manager.showArray(students);

    }
}
