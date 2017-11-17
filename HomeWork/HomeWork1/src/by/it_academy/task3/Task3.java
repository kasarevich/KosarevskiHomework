package by.it_academy.task3;

public class Task3 {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;
        int r = 3;
        double c = Math.sqrt((double)(a * a + b * b));
        if ((double)(r * 2) >= c) {
            System.out.println("Круг диаметром " + r * 2 + " полностью закроет прямоугольник с диагональю " + c);
        } else {
            System.out.println("Круг диаметром " + r * 2 + " не закроет прямоугольник с диагональю " + c);
        }

    }
}