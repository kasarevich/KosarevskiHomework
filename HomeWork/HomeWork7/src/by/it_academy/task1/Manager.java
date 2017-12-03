package by.it_academy.task1;

import java.util.Date;
import java.util.Scanner;

public class Manager {
        static public Student input() {
            Scanner in = new Scanner(System.in);
            Date date = new Date();
            System.out.println("Введите имя:");
            String name = in.next();
            System.out.println("Введите фамилию:");
            String surname = in.next();
            System.out.println("Введите год рождения:");
            date.setYear(in.nextInt());
            System.out.println("Введите месяц рождения:");
            date.setMonth(in.nextInt());
            System.out.println("Введите день рождения:");
            date.setDate(in.nextInt());
            System.out.println("Введите час рождения:");
            date.setHours(in.nextInt());
            System.out.println("Введите минту рождения:");
            date.setMinutes(in.nextInt());

            Student student = new Student(name, surname, date);
            return student;
        }

}
