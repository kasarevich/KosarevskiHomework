package by.it_academy.task3;
import java.util.Arrays;

/*
3. Напишите программу, которая печатает массив, затем инвертирует (то есть меняет местами первый элемент с последним, второй — с предпоследним и т.д.), и вновь печатает.
 */
public class Task3 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0 + (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        int n = arr.length-1;
        for (int i=0; i<arr.length/2; i++){
            int buf = arr[i];
            arr[i] = arr[n];
            arr[n] = buf;
            n--;
        }
        System.out.println(Arrays.toString(arr));

    }
}
