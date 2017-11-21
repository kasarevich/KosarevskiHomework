package by.it_academy;

public class People {

    public static int staticValue;

    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public People() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
