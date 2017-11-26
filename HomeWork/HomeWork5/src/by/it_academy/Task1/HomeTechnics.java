package by.it_academy.Task1;

/**
 * Абстрактный класс бытовой техники. У потомков общее поле - потребляемая мощность. Клас является подклассом Technics
 * В нем только перегрузка конструктора, потому что переопределять метод действия на этом этапе рано - у всех видов техники очень разные действия
 */
public abstract class HomeTechnics extends Technics {

    private int power;  // Потребляемая мощность

    public HomeTechnics() {
        super();
    }

    public HomeTechnics(String name) {
        super(name);
        this.power = 0;
    }

    public HomeTechnics(int power) {
        super();
        this.power = power;
    }

    public HomeTechnics(String name, int power) {
        super(name);
        this.power = power;
    }

}
