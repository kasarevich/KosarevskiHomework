package by.it_academy.task3;

/*
Создать абстрактный класс "Фигура"  + классы, которые будут его реализовывать: "Квадрат", "Прямоугольник", "Треугольник" и "Круг".
В абстрактном классе создать абстрактный метод "расчет площади".
В классах конкретных фигур у вас должны быть необходимые переменные и методы для задания входных значений и необходимых расчетов (лучше сделать конструктор).
По итогу должна быть программа, где можно создать класс нужной фигуры, задать параметры сторон, углов и рассчитать площадь этих фигур.
Заодно вспомните математику :)  и попробуете класс Math() с помощью, которого можно рассчитать синусы и тд.
*/

import by.it_academy.task3.shapes.Rectangle;
import by.it_academy.task3.shapes.Round;
import by.it_academy.task3.shapes.Square;
import by.it_academy.task3.shapes.Triangle;

public class Main {
    static public void main(String[] args) {

        Triangle triangle = new Triangle("Треугольник", 5, 3);
        Square square = new Square("Квадрат", 10);
        Rectangle rectangle = new Rectangle("Прямоугольник",5, 2);
        Round round = new Round("Круг", 5);

        System.out.println(triangle.getName());
        System.out.println("Площадь равна " + triangle.getSquare() + " квадратных метров");

        System.out.println(square.getName());
        System.out.println("Площадь равна " + square.getSquare() + " квадратных метров");

        System.out.println(rectangle.getName());
        System.out.println("Площадь равна " + rectangle.getSquare() + " квадратных метров");

        System.out.println(round.getName());
        System.out.println("Площадь равна " + round.getSquare() + " квадратных метров");


    }
}
