package by.it_academy.task2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Попробуйте создать файл .txt с какими-нибудь записями, потом прочитать его в программе и вывести данные в консоль.
//+ попробуйте создать свой файл и записать туда информацию, введенную с консоли.
public class Main {
    public static void main(String [] arg){


    System.out.println("Открываем существующий файл и выводим на консоль:");
    try{
    read("D:\\KosarevskiHomework\\HomeWork\\HomeWork7\\example1.txt");}
    catch (IOException ex){
        System.out.println(ex.getMessage());
    }

    System.out.println("Создаем свой файл и записываем в него данные с консоли:");
        try {
            input();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public static void read(String filename)throws IOException{
        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);
        while (scanner.hasNextLine()){       //Проверяем, есть ли следующая строка
            System.out.println((scanner.nextLine()));
        }
        fr.close();
    }

    public static void input() throws IOException{
            Scanner in = new Scanner(System.in);
            System.out.println("Введите строку:");
            String s = new String(in.nextLine());
            FileWriter fw = new FileWriter("D:\\KosarevskiHomework\\HomeWork\\HomeWork7\\example2.txt");
            fw.write(s);
            fw.close();
            read("D:\\KosarevskiHomework\\HomeWork\\HomeWork7\\example2.txt");
    }

}
