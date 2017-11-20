package by.it_academy.task2;
import java.util.Scanner;

import java.util.Scanner;

/*
Представьте, что вам необходимо написать метод, определяющий количество страниц для вывода N новостей с учетом того,
что на одной странице помещается 10 записей. В итоге у вас будет метод, который возвращает количество страниц,
а на вход принимает количество новостей. Помните, что тут округлять нужно всегда к большему.
 */

public class Task2 {
    public static void main(String[] arg) {
      Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of news:\n news = ");
        int news = scanner.nextInt();
        System.out.println("For public " + news + "news need " + pagesCalc(news) + " pages");
    }


    /**
     *
     * @param n - the number of news
     * @return the mumber of psges
     */

    public static int pagesCalc(int n){
        int p = n/10;
        if (n % 10 > 0)
            p++;
        return p;
    }

}
