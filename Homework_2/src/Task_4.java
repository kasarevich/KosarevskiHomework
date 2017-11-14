import java.util.Arrays;

/*
Написать программу, определяющую, образуют ли цифры некоторого числа строго возрастающую последовательность. Например: 123 – образуют, 212 – не образуют.
 */
public class Task_4 {
    public static void main(String[] args) {
        int num = 100 + (int) (Math.random() * 1000);
        System.out.println("default number = " + num);
        int lengthNum = (int)Math.log10(num)+1;          // Определение количества цифр в числе
        int arr [] = new int[lengthNum];
            for(int i=arr.length-1; i>=0; i--){
                arr[i] = num%10;
                num = num/10;
            }
        int arr1[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);                             //Сортировка по возрастанию буфферного массива

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

        if(Arrays.equals(arr, arr1)){                  //Сравнение отсортриованного и исходного массивов
            System.out.println("The digits is make growing order");
        }
        else{
            System.out.println("The digits do not make growing order");
        }

    }
}
