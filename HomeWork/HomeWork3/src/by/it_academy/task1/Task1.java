package by.it_academy.task1;
import java.util.Arrays;
import java.util.Scanner;

/*
Создайте массив с 10-ю переменными типа int.
Значения необходимо вводить с клавиатуры в отдельном методе.
Затем выведите все значения на экран также в отдельном методе в виде:
"значение" | "значение 2" | "значение 3" |  и тд. -
Далее отсортируйте массив по возрастанию способами из статьи или любыми другими алгоритмами.
Результат вывести на экран:
"значение" | "значение 2" | "значение 3" |  и тд.
Далее найдите в массиве все четные числа и выведите их на экран:
"значение" | "значение 2" | "значение 3" |  и тд.

В итоге у вас должна получиться программа как минимум с 3 методами:
1- для ввода данных с клавиатуры
2 - для сортировки
3 - для вывода

Вывод значений массива на экран должен быть сделан в отдельном методе,
этот метод будет использоваться для вывода значений массива до сортировки и после сортировки.

Сортировку нужно сделать 3-мя различными способами (на ваш выбор).

 */
public class Task1 {
    public static void  main(String []arg){
        int [] arr = new int[10];
        arr = input(arr);

        output(arr);
        arr = sort(arr);
        output(arr);
    }


    static public int[] input(int a[]){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < a.length; i++){
            System.out.print("Enter arr[" + i + "]: " + "arr[" + i + "] = " );
            a[i] = scanner.nextInt();
        }
        return a;
    }

    static public void output(int a[]){
        System.out.print("[");                      // Не понимаю зачем, но вы сказали в слэк
        for (int i = 0; i < a.length; i++){         //"@Dima нет, там нужно закрывать скобкой ] - в этом то и смысл был, что бы вы красиво обработали эту ситуацию"
            System.out.print("\t" + a[i] + "\t");
            if(i!=a.length-1)
                System.out.print("|");
        }
        System.out.println("]");

    }

    static public int[] sort (int a[]){
        for (int i = 0; i < a.length; i++){
            int min = a[i];
            int indexMin = i;
            for (int j = i+1; j<a.length; j++){
                if(a[j]<min){
                    int buf  = a[i];
                    a[i] = a[j];
                    a[j] = buf;
                }

            }
        }

        return a;
    }
}