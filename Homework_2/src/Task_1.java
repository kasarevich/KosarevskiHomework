/*Создайте массив с 10-ю переменными типа int. Используя оператор "for" найдите и выведите на экран наименьшее и наибольшее значение в массиве.
min value =  "значение которое у вас получилось".
max value =  "значение которое у вас получилось".
Далее замените наименьшее значение на 0, а наибольшее значение на 99 и выведите получившийся массив на экран в виде:
[23, 0, 34, 99, 43534].*/

import java.util.Arrays;

public class Task_1 {
    public static void main(String[] args){
    int[] arr = new int[10];
    for(int i = 0; i < arr.length ;i++){
        arr[i] = 0 + (int)(Math.random()*100);
      }
      int min = arr[0];
      int max = arr[0];
      int indexMin = -1;
      int indexMax = -1;
      for(int i = 1; i < arr.length; i++){
          if(min > arr[i]){
              min = arr[i];
              indexMin = i;
          }
          if(max < arr[i]){
              max = arr[i];
              indexMax = i;
          }
      }
        System.out.println(Arrays.toString(arr));
        System.out.println("min value = " + min + "\nmax value = " + max);
        arr[indexMin] = 0;
        arr[indexMax] = 99;
        System.out.println(Arrays.toString(arr));

    }
}
