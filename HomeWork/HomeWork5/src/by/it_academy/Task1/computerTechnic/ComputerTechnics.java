package by.it_academy.Task1.computerTechnic;

import by.it_academy.Task1.Technics;

/**
 * Абстрактный класс компьютерной периферии. Является подклассом Technics
 * Общее поле у потомков - время выполнения одной операции
 * В нем только перегрузка конструктора, потому что переопределять метод действия на этом этапе рано - у всех видов техники очень разные действия
 */
public abstract class ComputerTechnics extends Technics {
    private int timeOfOperation; //Время выполнения одной операции

    public ComputerTechnics() {
        super();
    }

    public ComputerTechnics(String name, int timeOfOperation) {
        super(name);
        this.timeOfOperation = timeOfOperation;
    }

    public int getTimeOfOperation() {
        return timeOfOperation;
    }

    public void setTimeOfOperation(int timeOfOperation) {
        this.timeOfOperation = timeOfOperation;
    }
}
