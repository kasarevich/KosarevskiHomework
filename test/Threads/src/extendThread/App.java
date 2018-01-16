package extendThread;

public class App {
    public static void main(String[] args) {
        System.out.println("name of thread is " + Thread.currentThread().getName());
        MyNewThread myNewThread = new MyNewThread();
        myNewThread.start();
    }
}

class MyNewThread extends Thread{
    @Override
    public void run(){
        System.out.println("name of thread is " + Thread.currentThread().getName());
        }
        }
