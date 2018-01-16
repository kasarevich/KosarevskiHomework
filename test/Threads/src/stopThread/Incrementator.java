package stopThread;

public class Incrementator extends Thread {
    private volatile boolean isIncrement = true;
    private volatile boolean isFinish = false;

    public void changeAction(){
        isIncrement = !isIncrement;
    }
    public void finish(){
        isFinish = true;
    }

    @Override
    public void run(){
        do {
            if(!isFinish){
                if(isIncrement){
                    App.value ++;
                }else{
                    App.value --;
                }

                System.out.println("The value oj App.value is " + App.value);

            }
            else return;

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while (true);
    }
}
