package безым;

public class App {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        myThread.start();
        System.out.println("main thread is finished");
    }



}
