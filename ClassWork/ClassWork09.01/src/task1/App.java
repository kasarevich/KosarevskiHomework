package task1;

public class App {
    public static void main(String [] args){

        Manager manager = Manager.getInstance();
        manager.setA("AAAAAAAAA");
        Manager manager2 = Manager.getInstance();
        System.out.println(manager2.getA());


    }
}
