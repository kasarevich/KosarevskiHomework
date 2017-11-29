package by.it_academy.task3.shapes;

import by.it_academy.task3.Shape;

public class Rectangle extends Shape {
    private double side1;
    private double side2;

    public Rectangle(String name, double side1, double side2) {
        super(name);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getSquare(){
        return(side1 * side2);
    }
}
