package by.it_academy.task6;

public class Task6 {
    public static void main(String[] args) {
        double x = 2.0D;
        double s = 1.0D;
        double t = 3.0D;
        double num = Math.pow(Math.sin(Math.pow(x, t)), 2.0D);
        double den = Math.sqrt(1.0D + Math.pow(x, s));
        double y = num / den;
        System.out.println("y = " + y);
    }
}
