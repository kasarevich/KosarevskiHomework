package by.it_academy.task3.shapes;

import by.it_academy.task3.Shape;

public class Triangle extends Shape{
    private double side;
    private double hight;

    public Triangle(String name, double side, double hight) {
        super(name);
        this.side = side;
        this.hight = hight;
    }

    @Override
    public double getSquare(){
        return ((side * hight)/2);
    }
}
