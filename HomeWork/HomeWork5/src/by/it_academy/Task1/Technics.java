package by.it_academy.Task1;

// Создать иерархию классов, описывающих бытовую технику. Иерархия должна иметь хотя бы три уровня. Обязательно использовать хотя бы один абстрактный класс с абстрактными методами.

/**
 * Абстрактный класс техника. общее у всех только имя. Имеет 2 наследника - бытовая техника и компьютерная периферия(HomeTechnics, ComputerTechnics)
 */
public abstract class Technics {
    private String name;

    public Technics() {
        this.name = "None";
    }

    public Technics(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void doSth();    // Абстрактный метод выполнения действия какой-либо техникой

}
