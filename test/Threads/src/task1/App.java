package task1;

public class App {
    public static void main(String[] args) {
        System.out.println("main thread");
        System.out.println(Thread.currentThread().getName());

        MyThreadClass my = new MyThreadClass();
        Thread myThread = new Thread(my);
        myThread.start();
    }

}

class MyThreadClass implements Runnable{
    @Override
    public void run(){
        System.out.println("snd Thread");
        print();
        }
        public void print(){
            System.out.println(Thread.currentThread().getName());
        }
}
