package task2;


public class App {
    //private static Object object = new Object(); // - общая переменная для всех экземпляров Апп. Синхронизация по ней
    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                App main = new App();
                main.print10();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                App main = new App();
                main.print10();
            }
        });

        thread1.start();
        thread2.start();


    }

    public void print10() {// static sinchronized  - то же самое

       synchronized (App.class){  //object

        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }
}
