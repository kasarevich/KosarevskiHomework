/*
Создайте массив типа int. Отсортируйте массив любым способом (по убыванию либо по возрастанию). Результат вывести на экран.
 */

import java.util.Arrays;

public class Task_5 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0 + (int) (Math.random() * 100);
        }
        System.out.println("Default array:\n" + Arrays.toString(arr));

       // Arrays.sort(arr);           // - Самый быстрый способ, но если задание именно на умение перебора элементов, то дальше выполняю методом "пузырька"

        for (int i = 0; i < arr.length; i++){
            int min = arr[i];
            int index = i;
            for(int j=i+1; j<arr.length; j++){
                if (arr[j]<min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (i != index) {
                int buf = arr[i];
                arr[i] = arr[index];
                arr[index] = buf;
            }
        }
        System.out.println("Sorted array:\n" + Arrays.toString(arr));

    }
}
