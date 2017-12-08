package by.it_academy.Exc;



public class Main {
    public static void main(String []arg){
        try{
            test(5);
        }catch (MyException e){
            System.out.println(e.getRussianMessage());
        }
    }
    public static void test(int a) throws MyException{
        if (a == 5){
            throw new MyException ("5 - недопустимый символ");
        }
    }
}

