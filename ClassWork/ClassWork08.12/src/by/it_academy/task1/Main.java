package by.it_academy.task1;


import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(){

        ArrayList<String> array = new ArrayList<>();
        array.add("1111");
        array.add("2222");
        array.add("3333");
        array.add("4444");

        // 4 - к-во элементов
        System.out.println("Размер листа:" +array.size());
        array.add("5555");
        // 5 - к-во элементов
        System.out.println("Размер листа:" +array.size());

        // значение под индексом 0
        System.out.println(array.get(0));

        // удаляет по индексу, можно так же по значению
        array.remove(2);

        // в индекс 3 вставится новый элемент, остальные сместятся вправо
        array.add(3,"1010");

        // заменить элемент в 3 индексе на новый. то, что было в 3 - удаляется
        array.set(3, "3333");

    }
}
