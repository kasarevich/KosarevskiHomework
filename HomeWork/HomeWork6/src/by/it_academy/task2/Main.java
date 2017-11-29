package by.it_academy.task2;
import java.util.Arrays;
public class Main {
    static public void main(String[] args) {
        int[] arr = new int[10];
        int[] arr1 = new int[20];

        for (int i =0; i < arr.length; i++) {
            arr[i] = 1;
        }

        System.out.println(Arrays.toString(arr)); // [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

        for (int i =0; i < arr1.length; i++) {
            arr1[i] = 2;
        }

        System.out.println(Arrays.toString(arr1)); //[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]

        System.arraycopy(arr, 0, arr1, 5, 10);
        System.out.println(Arrays.toString(arr1)); //[2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2]
    }


}
