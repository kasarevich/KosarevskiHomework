package by.it_academy.task3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Manager {

    static public void input(File file, boolean apend)throws Exception {
        FileWriter fw = new FileWriter(file);
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while(i == 0){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = in.next();
        System.out.println("Введите фамилию:");
        String surname = in.next();
        System.out.println("Введите номер зачетной книжки:");
        int id = in.nextInt();
        fw.write(name + " " + surname + " " + id + "\n");
        System.out.println("Добавить еще?");
        i = sc.nextInt();
        }
        fw.flush();
        fw.close();
    }


    public static void read(File file, ArrayList<Student> s)throws Exception{
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);
        while(scan.hasNextLine()){
            String name = scan.next();
            String surname = scan.next();
            int id = Integer.parseInt(scan.next());
            s.add(new Student(name,surname,id));
        }
        fr.close();
    }


    public static void showArray(ArrayList<Student> s){ //Выводит на экран всех студентов
        for (int i = 0; i < s.size(); i++) {
            System.out.println(i+1 + ".\tИмя: " + s.get(i).getName() + "\n\tФамилия: " + s.get(i).getSurname() +"\n\tНомер зачетки: " + s.get(i).getId());
            System.out.println("    ---------------------");
        }
    }

}
