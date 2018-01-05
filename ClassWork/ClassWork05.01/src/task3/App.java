package task3;

public class App{
   /* private static AbstractClass a = new AbstractClass() {
    @Override
    public void test() {

    }
};*/
    public static void main(String [] arg){
        //makeSmth(a);
        makeSmth(new AbstractClass() {
            @Override
            public void test() {

            }
        });




    }

    public static void makeSmth(AbstractClass obj){
        obj.test();
    }

}
