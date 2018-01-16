package task2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // С двумя потоками почти ни разу не заметил вмешательства в метод print10,
        // поэтому создал три потока

        MyThread firstThread = new MyThread();
        MyThread secondThread = new MyThread();
        MyThread thirdThread = new MyThread();

        firstThread.setName("First thread");
        secondThread.setName("Second thread");
        thirdThread.setName("Third thread");

        System.out.println("Enter \"Start\" ");
        Scanner in = new Scanner(System.in);

        if(in.next().equals("Start")) {
            firstThread.start();
            secondThread.start();
            thirdThread.start();
        }

    }

    public static synchronized void print10(int [] arr){
        System.out.print(Thread.currentThread().getName() + " : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
}

