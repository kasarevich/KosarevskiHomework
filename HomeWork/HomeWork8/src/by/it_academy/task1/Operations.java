package by.it_academy.task1;

class Operations {

    static double plus(double num1, double num2){
        return num1 + num2;
    }

    static double minus(double num1, double num2){
        return num1 - num2;
    }

    static double dividing(double num1, double num2){
            if(num2 == 0){
                System.out.println("Второй аргумент равен нулю. Деление на ноль невозможно");
                return 0;
            }
            return num1 / num2;
    }

    static double multiplication(double num1, double num2){
        return num1 * num2;
    }
}
