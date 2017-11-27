package by.it_academy.Task1;


//Создать иерархию классов, описывающих бытовую технику. Иерархия должна иметь хотя бы три уровня. Обязательно использовать хотя бы один абстрактный класс с абстрактными методами.


import by.it_academy.Task1.computerTechnic.Printer;
import by.it_academy.Task1.homeTechnic.Hoover;
import by.it_academy.Task1.homeTechnic.Microwawe;

public class Task1 {
    public  static void main(String [] arg){
    Hoover hoover = new Hoover("Philips", 2000, 1200); //имя, потребляемая мощность, мощность всасывания
    hoover.timeCalc(20); //Расчитывает, сколько времени нужно на уборку площади 20 кв. м.
    hoover.doSth();


    Microwawe microwawe = new Microwawe("Bosch", 2000, 10); //Имя, потребляемая мощность, время разогрева
    microwawe.doSth();  //Показывает оставшееся время, сообщает о готовности


    Printer printer = new Printer("Xerox", 5, 20);  //Имя, время выполнения одной операции(печати 1 страницы), количество страниц
    printer.doSth(); //Сообщает о готовности, выводит время, которое потребовалось на печать
    }
}
