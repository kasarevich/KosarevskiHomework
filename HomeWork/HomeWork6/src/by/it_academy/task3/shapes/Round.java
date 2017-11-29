package by.it_academy.task3.shapes;

import by.it_academy.task3.Shape;

public class Round extends Shape {
    private double r;

    public Round(String name, double r) {
        super(name);
        this.r = r;
    }

    @Override
    public double getSquare(){
        return (Math.PI * Math.pow(r, 2));
    }
}
