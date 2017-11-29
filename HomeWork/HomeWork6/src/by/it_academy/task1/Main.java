package by.it_academy.task1;

import by.it_academy.task1.atm.ConcreteATM;

import java.util.Scanner;

public class Main {
   static public void main(String []args){
       ConcreteATM atm = new ConcreteATM("BPSATM", "Panasonic");
       Scanner in = new Scanner(System.in);byte usl = 0;
       do {
           System.out.println("Введите 1 - для добавления наличных денег на счет.\n\t\t2 - для снятия денег со счета\n\t\t3 - для проверки количества купюр" +
                   "\n\t\t4 - для пополнения счета мобильного телефона\n\t\t5 - для погашения штрафа\n\t\t6 - для того, чтобы узнать название банкомата и производителя");
           byte num = in.nextByte();
           switch (num){
               case 1:
                   System.out.println("Введите сумму:");
                   int sum = in.nextInt();
                   if(atm.add(sum))
                       System.out.println("Деньги успешно добавлены!");
                   else
                       System.out.println("Неверная сумма! \nБанкомат принимает купюры номиналом 100р, 50р, 20р");
                   break;
               case 2:
                   System.out.println("Введите сумму:");
                   int sum1 = in.nextInt();
                   atm.take(sum1);
                   break;
               case 3:
                   atm.check();
                   break;
               case 4:
                   System.out.println("Введите сумму для пополнения счета:");
                   int sum2 = in.nextInt();
                   atm.toPayMobileServices(sum2);
                   break;
               case 5:
                   System.out.println("Введите сумму для погашения штрафа:");
                   int sum3 = in.nextInt();
                   atm.toPayFines(sum3);
                   break;
               case 6:
                   System.out.println(atm.nameOfAtm());
                   System.out.println(atm.producer());
                   break;
               default:
                   break;
           }
           System.out.println("Продолжить? Да - нажмите 0, нет - нажмите 1:");
           usl = in.nextByte();
       }while (usl == 0);



   }
}
