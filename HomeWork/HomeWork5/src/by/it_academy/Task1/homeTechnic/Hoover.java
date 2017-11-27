package by.it_academy.Task1.homeTechnic;

/**
 * Потомок бытовой техники
 * Пылесос. Свои поля - Мощность всасывания и время уборки 1 метра квадратного
 */
public class Hoover extends HomeTechnics {
    private final double KOEFF;

    {
        KOEFF = 0.02;     // Выдуманный коэффициент для расчета времени уборки квадратного метра( с предметной областью знаком слабо, поэтому ввел характеристики, на которые хватило фантазии)
    }

    private int suctionPower;
    private double timeOfCleaning;    // время уборки 1 кв. метра

    public Hoover() {
        super();
        this.suctionPower = 0;
        this.timeOfCleaning = 0;
    }

    public Hoover(String name, int power, int suctionPower) {
        super(name, power);
        this.suctionPower = suctionPower;
        this.timeOfCleaning = suctionPower * KOEFF;
    }

    public int getSuctionPower() {
        return suctionPower;
    }

    public void setSuctionPower(int suctionPower) {
        this.suctionPower = suctionPower;
    }

    public double getTimeOfCleaning() {
        return timeOfCleaning;
    }

    public void setTimeOfCleaning(double timeOfCleaning) {
        this.timeOfCleaning = timeOfCleaning;
    }

    /**
     * Выводит на экран время, необходимое для уборки
     * @param square - площадь, которую необходимо убрать
     */
    public void timeCalc(int square){
        double time = square * timeOfCleaning;
        System.out.println("Время уборки помещения площадью " + square + " квадратных метров пылесосом " + getName() + "\n с мощностью всасывания " +getSuctionPower()+ " Ватт составляет " + time + " секунд");
    }

    @Override
    public void doSth() {
        System.out.println("Бытовая техника выполняет уборку");
    }
}
