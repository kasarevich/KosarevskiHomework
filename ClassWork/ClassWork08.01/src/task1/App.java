package task1;

public class App {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {

        System.out.println("Start main");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (;;){
                    System.out.println("Daemon is running");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

            Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){

                    System.out.println("Thread 2 i = " + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.setDaemon(true); // как только все потоки завершились, а остался только демон, мейн прервет работу демона
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(100); //Тормозим главный поток на 3 сек
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // thread1.interrupt();// Встроенный метод для завершения работы потока
        //thread1.setFinish(true); завершаем поток

       /* try {
            thread1.join();  //Ожидание завершения работы потока
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("End main");



}
    public synchronized static void openFile(){ //для регулирования доступа к файлу между потоками
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}