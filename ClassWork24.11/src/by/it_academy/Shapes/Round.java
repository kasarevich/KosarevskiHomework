package by.it_academy.Shapes;

public class Round extends  Shape{
    final double Pi = 3.14;
    private double radius;

    public Round(double radius) {
        this.radius = radius;
        setSquare(Pi * radius * radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
