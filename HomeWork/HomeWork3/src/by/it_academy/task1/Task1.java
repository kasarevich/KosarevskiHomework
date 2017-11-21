package by.it_academy.task1;
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
        System.out.println("Default array:");
        output(arr);
        arr = bubleSort(arr);
        System.out.println("Sorted array:");
        output(arr);
        int evenArr [] = new int[evenCalc(arr)];    // Создал новый массив с четными, чтобы пользоваться методами вывода массивов, написанным ранее
        int i = 0;
        for (int j = 0; j < arr.length; j++) {         // Записываем в новый массив только четные, затем выводим на экран четные в том же формате, что и начальный массив
            if (arr[j] % 2 == 0){
                evenArr[i] = arr[j];
                i++;
            }
        }
        System.out.println("Array contains even only:");
        output(evenArr);


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

    static public int[] bubleSort (int a[]){
        for (int i = a.length - 1; i > 0 ; i--){
            for (int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    int buf  = a[j];
                    a[j] = a[j+1];
                    a[j+1] = buf;
                }
            }
        }

        return a;
    }

    // Сортировка выбором (в данной программе метод не используется)
    public static int[] selectionSort(int[] a){
          for (int i = 0; i < a.length; i++) {
              int min = a[i];
              int min_i = i;
              for (int j = i + 1; j < a.length; j++) {
                  if (a[j] < min) {
                      min = a[j];
                      min_i = j;
                  }
              }
              if (i != min_i) {
                  int buf = a[i];
                  a[i] = a[min_i];
                  a[min_i] = buf;
              }
          }
            return a;
    }
    // Сортировка перемешиванием (в данной программе метод не используется)
    public static int [] shakerSort(int array[]) {
         int buff;
         int left=0;
         int right=array.length-1;
         do {
             for (int i=left; i<right;i++) {
                     if (array[i]>array[i+1]) {
                             buff = array[i];
                             array[i] = array[i + 1];
                             array[i + 1] = buff;
                         }
                 }
             right--;
             for (int i=right; i>left; i--) {
                     if (array[i]<array[i-1]) {
                             buff = array[i];
                             array[i] = array[i - 1];
                          array[i - 1] = buff;
                      }
               }
                  left++;
            } while (left <right);
         return array;
           }


    /**
     * Method returns size of new array
     * @param a
     * @return Size ow new array
     */

    static public int evenCalc (int[] a){
        int counter = 0;
        for (int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0)
                counter ++;
        }
        return counter;
    }

}