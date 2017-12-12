package by.it_academy.task2;

public class Lamp {
    private String name;
    private int illuminance;

    public Lamp(String name, int illuminance) {
        this.name = name;
        this.illuminance = illuminance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIlluminance() {
        return illuminance;
    }

    public void setIlluminance(int illuminance) {
        this.illuminance = illuminance;
    }
}
