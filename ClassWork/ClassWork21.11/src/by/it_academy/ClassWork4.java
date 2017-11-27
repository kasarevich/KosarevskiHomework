package by.it_academy;

public class ClassWork4 {
    public static void main (String []arg){
        People people1 = new People("Alex", 15);


        People.staticValue = 100;


        People people2 = new People();
        people2.setName("Andrey");
        people2.setAge(22);
        People.staticValue = 200;

        printPeople(people1);
        printPeople(people2);


        Car car1 = new Car();
        car1.name = "Audi";
        car1.mogel = "A6";
        car1.year = 2002;

        Car car2 = new Car();
        car2.name = "Ford";
        car2.mogel = "Mondeo";
        car2.year = 2003;

        printCar(car1);
        printCar(car2);

    }

    public static void printPeople(People people){
        System.out.println("name = " + people.getName());
        System.out.println("age = " + people.getAge());
        System.out.println("static = " + People.staticValue);
    }

    public static void printCar(Car car){
        System.out.println("Brand: " + car.name);
        System.out.println("Model: " + car.mogel);
        System.out.println("Year: " + car.year);
    }
}
