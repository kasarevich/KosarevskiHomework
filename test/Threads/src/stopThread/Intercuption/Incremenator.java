package stopThread.Intercuption;

public class Incremenator extends Thread {
    private volatile boolean isChange = true;
    public void changeAction(){
        isChange = !isChange;
    }
    @Override
    public void run(){
        do{
            if(!Thread.interrupted()) {
                if (isChange) {
                    App.value++;
                } else {
                    App.value--;
                }
                System.out.println(App.value);
            }
            else return;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }

        }while (true);
    }

}
