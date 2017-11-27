package by.it_academy;

public class Main {
    public static void main(String []arg){

        String text = "a" + "b" + "c";                  //Обрабатывается дольше, потому что стринг - массив чаров, а массивы неизменны
                                                        // Здесь при каждой конкатенации создается новый стринг. поэтому лучше исп.
                                                        // вариант, приведенный ниже. StrindBuilder
        text.concat("sdfs"); // Для стринга это лучше, чем +, но при больших объемах, хуже чем стрингбилдер.


        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
        builder.append("b");
        builder.append("d");
        builder.append("a");
        builder.append("aef");
        builder.append("a");

        String text2 = builder.toString();              //






        // OOП//   // OOП//   // OOП//   // OOП//   // OOП//   // OOП//   // OOП//   // OOП//   // OOП//   // OOП//   // OOП//


        Patient patient = new Patient();


        Object object = new Object(); // От него наследуются все классы. В нем содержатся общие возможности для всех классов
                                      // equals(), hashCode() и тд



        }
}
