package stopThread;

public class App {
    public static int value = 0;
    static Incrementator incrementator;
    public static void main(String[] args) {
        incrementator = new Incrementator();
        System.out.println("The value is ");
        incrementator.start();

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) { }
            incrementator.changeAction();
        }
        incrementator.finish();
    }
}
