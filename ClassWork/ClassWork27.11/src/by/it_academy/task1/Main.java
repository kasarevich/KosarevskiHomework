package by.it_academy.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    static public void main(String [] arg){
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        String dataText = sdf.format(date);
        System.out.println(dataText);




            String inputDate = "2017-11-30 10-03";
            Date data2 = null;
            try {
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            data2 = sdf2.parse(inputDate);
            System.out.println(data2.toString());
        } catch (Exception e){
            System.out.println("format ex");
        }
    }
}
