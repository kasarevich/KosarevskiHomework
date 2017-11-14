/* Создайте массив с 10-ю переменными типа float. Далее найдите дубликаты и выведите их количество.
Пример: есть массив {2, 3, 5, 7, 6, 5, 7, 3, 7, 20} - в данном массиве цифра 3 и 7 повторяются.
В результате выполнения программы на экран должно вывести:
[3] - повторений 2
[7] - повторений 3 */

import java.util.Arrays;

public class Task_2 {
    public static void main(String []args){
        int arr [] = new int [10];       // Сделал int вместо float умышленно, для наглядности. Если принципиально, можно везде поменять на float - работать будет, проверял.
                                         // просто при заполнении рандомом даже от 0 до 5 маленькие шансы, что сгенерируются 2 одинаковых float
        for(int i = 0; i < arr.length ;i++){
            arr[i] = 0 + (int)(Math.random()*5);
        }
        System.out.println(Arrays.toString(arr));

        for (int i =0; i < arr.length; i++){
            if(ignore(arr, arr[i], i))                  // игнорируем элементы, которые уже проверяли
                continue;
            int counter = 1;
            for (int j = i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    counter++;
                }
            }
            if (counter > 1){
                System.out.println("[" + arr[i] + "] - is repeated " + counter + " times");
            }

        }
    }
    public static boolean ignore(int []array, int element, int poz)
    {
        int counter=0;
        for (int i = 0; i < poz; i++){
             if(array[i]==element)
                counter++;
        }
        if (counter > 0)
            return true;
        else return false;
    }
}
