package by.it_academy.task3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Manager {

    static public void input(File file)throws IOException {
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
        fw.close();
    }


    private static void read(File file, ArrayList<Student> s)throws IOException{
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


    public static void printFile(ArrayList<Student> s)throws IOException{ //Выводит на экран всех студентов
        File file = new File("Students.txt");
        if (file.length() !=0){
                read(file, s);
        }
/*        else {
            System.out.println("База пуста. Введите данные нового студента");
            input(file);
        }*/

    }

    public static void showArray(ArrayList<Student> s){ //Выводит на экран всех студентов
        for (int i = 0; i < s.size(); i++) {
            System.out.println(i + ". Имя: " + s.get(i).getName() + "\nФамилия: " + s.get(i).getSurname() +"\nНомер зачетки: " + s.get(i).getId());
        }
    }

}
