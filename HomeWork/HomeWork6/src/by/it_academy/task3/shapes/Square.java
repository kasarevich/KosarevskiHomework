package by.it_academy.task3.shapes;

import by.it_academy.task3.Shape;

public class Square extends Shape {
    private double side;

    public Square(String name, double side) {
        super(name);
        this.side = side;
    }

    @Override
    public double getSquare(){
        return (Math.pow(side, 2));
    }
}
