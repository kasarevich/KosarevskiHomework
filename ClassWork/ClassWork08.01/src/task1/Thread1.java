/*
package task1;

public class Thread1 extends Thread {
   */
/* private  boolean isFinish = false; //  ля завершения потка корректно, не мгновенно

    public  void setFinish(boolean finish){
        isFinish = finish;
    }
*//*

    @Override
    public  void run(){
        for(int i = 0; i< 10; i++){
        //    if(isFinish) return;
            if(isInterrupted()) return;; // здесь переход в блок кэтч. "спячка" отключается, срабатывает эксепшн и там уже обрабатываем
            System.out.println("thread1 i = " + i );
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("stop by InterruptedException");
                return;
            }
        }
    }
}
*/
