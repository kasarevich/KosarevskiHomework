package by.it_academy.task2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

// st nd th
public class Main {
    static public void main(String [] arg){
        Date date = new Date();
        int day = date.getDate();
        String pattern = "MMM dd-'" + getPostfix(day) + "' hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT +0"));
        String dataText = sdf.format(date);
        System.out.println(dataText);

        /**
         * Gregorian calendar
         */
        GregorianCalendar calendar = new GregorianCalendar(); // текуще время
        calendar.setTime(date);                               // инициализация своей датой

        int day1 = calendar.get(GregorianCalendar.DAY_OF_MONTH); // Вместо того метода, который мы делали

        calendar.add(GregorianCalendar.DATE, 30); // ДОБАВИТЬ 30 ДНЕЙ К ТЕКУЩЕЙ ДАТЕ. С "-" БУДЕТ ОТНИМАТЬ.
        // МЕТОД set УСТАНОВИТ НА ТОЧНУЮ ДАТУ

        System.out.println(calendar.getTime().toString());
        /**
         *
         */


    }
        static public String getPostfix(int day){
        if (day >=11 && day <=13){
            return "th";
        }
        switch (day%10){
            case 1:{
                return "st";
            }
            case 2:{
                return "nd";
            }
            case 3:{
                return "rd";
            }
            default:{
                return "th";
            }
        }
        }
}
