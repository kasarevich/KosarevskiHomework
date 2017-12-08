package by.it_academy.task2;

public class Calculate {
    private double num1;
    private double num2;

    public Calculate() {
        this.num1 = 0;
        this.num2 = 0;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }



    public double plus(){
        return num1 + num2;
    }

    public double minus(){
        return num1 - num2;
    }

    public double multiplication(){
        return num1 * num2;
    }

    public double deviding(){
        return num1 / num2;
    }

}
