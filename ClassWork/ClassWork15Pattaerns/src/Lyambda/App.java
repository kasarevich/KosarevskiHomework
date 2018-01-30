package Lyambda;

public class App {
    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        // Лямбда-выражение ->
        // поскольку принимает класс с одним методом, то можно опустить
        // если больше одного метода, то лямбда не подходят
        Thread thread1 = new Thread(()->{

            // Содержимое RUN

        });



        test(new OnClick() {
            @Override
            public void onClick(int id) {

            }
        });

        /*
        test ->;
        */










        }










        public static void test(OnClick onClick){
        onClick.onClick(500);
    }





    interface OnClick{
        void onClick(int id);
    }


}
