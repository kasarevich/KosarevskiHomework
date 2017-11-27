package by.it_academy.Task1.homeTechnic;

/**
 * Наследник бытовой техники.
 * Микроволновая печь. Свое поле - время разогрева
 */
public class Microwawe extends HomeTechnics {

    private int timeOfHeating;

    public Microwawe() {
        super();
        this.timeOfHeating = 0;
    }

    public Microwawe(String name, int power, int timeOfHeating) {
        super(name, power);
        this.timeOfHeating = timeOfHeating;
    }

    public int getTimeOfHeating() {
        return timeOfHeating;
    }

    public void setTimeOfHeating(int timeOfHeating) {
        this.timeOfHeating = timeOfHeating;
    }

    /**
     * Выводит на экран время, которое осталось до готовности
     */
    @Override
    public void doSth(){
        for (int i = 0; i<timeOfHeating; i++){
            System.out.println("Выполняется разогрев. Осталось " + (timeOfHeating - i) + " секунд");
        }
        System.out.println("Разогрев выполнен! Печь " + getName());
    }
}
