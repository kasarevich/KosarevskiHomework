package by.it_academy.task5;

public class Task5 {
    public static void main(String[] args) {
        String s = "??##?#?#?#??#?#?#??#?#?##?";
        String s1 = s.replace("?", "HELLO ");
        String s2 = s1.replace("#", "");
        System.out.println("default string: " + s);
        System.out.println("replaced string: " + s1);
        System.out.println("finish string: " + s2);
    }
}
