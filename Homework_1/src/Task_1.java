
public class Task_1 {
    public static void main(String []args){
        String s = new String("MyFirstTask1");
        int x = s.length();
        System.out.println("Длина строки равна:"+x);
        int a = x/2;
        String s1 = s.substring(0,a);
        String s2 = s.substring(a,x);
        System.out.println("Первая часть строки:" + s1 + "\nВторая часть строки:" +s2);

    }
}