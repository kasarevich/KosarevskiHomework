package task1;


public class MyThread extends Thread {

    @Override
    public void run(){
        int [] array = new int[10];
        int index = 0;

        // от 1 до 100 не видно разницы, слишком мало результатов
        // для очевидного отличия синхронизированного и несинхронизированного,
        // поэтому печатаем от 1 до 1500 порциями по 10 цифр

            for (int i=1; i <= 1500; i++) {
                array[index] = i;
                if(i%10 == 0){
                    App.print10(array);
                    array = new int[10]; // обнуляем массив
                    index = 0;
                }else index ++;
            }
    }

}
