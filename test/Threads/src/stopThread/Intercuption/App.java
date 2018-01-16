package stopThread.Intercuption;


public class App {
    public static int value = 0;
    static Incremenator incremenator;
    public static void main(String[] args) {
        incremenator = new Incremenator();
        System.out.println("The value is ");
        incremenator.start();

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) { }
            incremenator.changeAction();
        }
        incremenator.interrupt();
    }
}
