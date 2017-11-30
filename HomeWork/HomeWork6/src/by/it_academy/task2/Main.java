package by.it_academy.task2;
import java.util.Arrays;
public class Main {
    static public void main(String[] args) {
        int[] arr = new int[10];
        int[] arr1 = new int[20];

        Arrays.fill(arr, 1);
        Arrays.fill(arr1, 0);

        System.out.println(Arrays.toString(arr)); // [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

        System.out.println(Arrays.toString(arr1)); //[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]

        System.arraycopy(arr, 0, arr1, 5, 10);
        System.out.println(Arrays.toString(arr1)); //[2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2]
    }


}
