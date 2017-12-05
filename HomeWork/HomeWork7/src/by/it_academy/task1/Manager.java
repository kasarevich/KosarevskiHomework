package by.it_academy.task1;

import java.text.SimpleDateFormat;
import java.util.*;


public class Manager {
    static SimpleDateFormat sdf =new SimpleDateFormat("yyyy год, M месяц");

    static public Student input() {
        Scanner in = new Scanner(System.in);
        Date date = new Date();
        System.out.println("Введите имя:");
        String name = in.next();

            System.out.println("Введите фамилию:");
            String surname = in.next();
            System.out.println("Введите год рождения:");
            date.setYear(in.nextInt()-1900);            // для корректной записи в случае чтения инт
            System.out.println("Введите месяц рождения:");
            date.setMonth(in.nextInt()-1);              // месяца с 0

            Student student = new Student(name, surname, date);
            return student;
        }
        public static void print(ArrayList<Student> s){ //Выводит на экран всех студентов
            for (int i = 0; i < s.size(); i++) {
                System.out.println(i + ". Имя: " + s.get(i).getName() + "\nФамилия: " + s.get(i).getSurname());
                System.out.println("Дaта рождения");
                System.out.println(sdf.format(s.get(i).getDate()));
            }
            }

        public static void search(ArrayList<Student> s){ //поиск среднего возраста
                long sum = 0;
                    for (int i = 0; i < s.size(); i++) {
                        sum += s.get(i).getDate().getTime();
                    }
                    Date date = new Date(sum/s.size());
                    long today = System.currentTimeMillis();
                    Date age = new Date(today-date.getTime()); //получаем возраст в лонг(разница между нашим временем и датой рождения)
                    SimpleDateFormat sd = new SimpleDateFormat("yy '" + patternYear(age) + "' M " + patternMonth(age)); //patternYear patternMonth - форматирование окончания
                    age.setYear(age.getYear()-1970);
                    age.setMonth(age.getMonth()-1);
                    System.out.println(sd.format(age));
        }
        public static String patternYear(Date date){
            int y = date.getYear();
            if(y == 1) {
                return "год";
            }else if(y == 2 || y == 3 || y==4){
                return "года";
            }else if(y%10 == 1){// Предполагаем, что среднего возраста выше 100 лет быть не может
                return "год";
            }else if (y%10 == 2 || y%10 == 3 || y%10 ==4){
                return "года";
            }
            else return "лет";
        }
    public static String patternMonth(Date date){
            int m = date.getMonth();
        if(m == 1 ){
            return "месяц";
        }else if(m == 2 || m == 3 || m == 4){
            return  "месяца";
        }else  if (m%10 == 1 ) {
            return "месяц";
        }else if(m%10 == 2 || m%10 == 3 || m%10 == 4) {
            return "месяца";
        }
        else return "месяцев";
    }

}
