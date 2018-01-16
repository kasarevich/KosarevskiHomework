package chickenAndEgg;

public class App {
    public static void main(String[] args) {
        ChickenVoice chickenVoice = new ChickenVoice();
        System.out.println("The controversy was started");
        chickenVoice.start();

        for (int i = 0; i < 5; i++) {

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Egg!");
        }
        if(chickenVoice.isAlive()){
            try {

                chickenVoice.join();

            } catch (InterruptedException e) { }
            System.out.println("The chicken was first");
        }
        else {
            System.out.println("The egg was first");
        }
    }

}

class ChickenVoice extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chicken!");
        }
    }
}
