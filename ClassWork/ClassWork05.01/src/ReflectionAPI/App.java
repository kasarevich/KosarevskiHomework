package ReflectionAPI;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class App {
    public static void main(String [] arg){
        Test test = new Test();
        Class classTest = test.getClass();
        System.out.println(classTest.getSimpleName());
        int mod = classTest.getModifiers();

        if(Modifier.isAbstract(mod)){
            System.out.println("Abstract");
        } else {
            System.out.println("Not abstract");
        }


        if(Modifier.isPublic(mod)){
            System.out.println("Public");
        } else {
            System.out.println("Not public");
        }

        Field[] fields = classTest.getFields();// только публичные поля
        System.out.println("------------------");
        for(Field field: fields){
            System.out.println("field name " + field.getName());
        }

        Field[] fields1 = classTest.getDeclaredFields();// All fields
        System.out.println("------------------");
        for(Field field: fields1){
            System.out.println("field name " + field.getName());
        }

        Method [] methods = classTest.getDeclaredMethods();
        for(Method method :methods){
            System.out.println("method "+ method.getName());
        }

        Field[] fields2 = classTest.getDeclaredFields();// All fields с данными
        System.out.println("------------------");
        System.out.println("fields name " + fields.toString());
        for(Field field: fields2){
            try {
                field.setAccessible(true);
                System.out.println("field name " + field.getName());
                System.out.println("field VALUE " + (int)field.get(test));
                field.set(test, 50);
                System.out.println("field VALUE " + (int)field.get(test));
            }catch (IllegalAccessException re){re.printStackTrace();}
        }
    }

}
