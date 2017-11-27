package by.it_academy.Task1.computerTechnic;

/**
 * Наследник компьютерной периферии(ComputerTechnics)
 * Свое поле - количество страниц для печать
 */
public class Printer extends ComputerTechnics {
    int num;   // количество листов для печати

    public Printer() {
        super();
        this.num = 0;
    }
      public Printer(String name, int timeOfOperation, int num) {
        super(name, timeOfOperation);
        this.num = num;
    }

    /**
     * Выводит на экран к-во распечатанных страниц и время, потраченное на это
     */
    @Override
    public void doSth(){
        int time = getTimeOfOperation() * num;
        System.out.println("Распечатано " + num + "страниц. Время печати : " + time + " секунд");
        System.out.println("Принтер " + getName());
    }
}
