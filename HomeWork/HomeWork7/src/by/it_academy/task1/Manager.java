package by.it_academy.task1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Manager {
    static SimpleDateFormat sdf =new SimpleDateFormat("yyyy M d HH:mm");

    static public Student input() {
        Scanner in = new Scanner(System.in);
        Date date = new Date();
        System.out.println("Введите имя:");
        String name = in.next();

            System.out.println("Введите фамилию:");
            String surname = in.next();
            System.out.println("Введите год рождения:");
            date.setYear(in.nextInt()-1900);            // для корректной записи в случае чтения инт
            System.out.println("Введите месяц рождения:");
            date.setMonth(in.nextInt()-1);              // месяца с 0
            System.out.println("Введите день рождения:");
            date.setDate(in.nextInt());
            System.out.println("Введите час рождения:");
            date.setHours(in.nextInt());
            System.out.println("Введите минту рождения:");
            date.setMinutes(in.nextInt());

            Student student = new Student(name, surname, date);
            return student;
        }
        public static void print(Student s, int i){
                System.out.println(i + ". Имя: " + s.getName() + "\nФамилия: " + s.getSurname());
                System.out.println("Дaта рождения");
                System.out.println(sdf.format(s.getDate()));
            }
        public static void search(ArrayList<Student> s){

        }

}
