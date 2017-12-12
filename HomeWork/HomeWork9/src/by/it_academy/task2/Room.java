package by.it_academy.task2;

import by.it_academy.task2.Exceptions.IlluminanceToMuchException;
import by.it_academy.task2.Exceptions.SpaceUsageTooMuchException;
import by.it_academy.task2.Illumination.Illumination;
import by.it_academy.task2.Illumination.Lamp;
import by.it_academy.task2.Illumination.Window;

import java.util.LinkedList;
import java.util.List;

public class Room {
    private String name;
    private double square;
    private double squareOfFurniture;
    private int illuminance;
    private int countOfWindows;
    private LinkedList<Lamp> lamps = new LinkedList<>();
    private LinkedList<Furniture> furnitureList = new LinkedList<>();

    public Room(String name, double square , int countOfWindows)throws IlluminanceToMuchException {
        this.name = name;
        this.square = square;
        this.countOfWindows = countOfWindows;
        if(countOfWindows > 0){
              this.illuminance += (700*countOfWindows);
        }
                if(illuminance > 4000){
                    throw new IlluminanceToMuchException("Превышено количество окон!");
                }
            }



    public String getName() {
        return name;
    }

    public double getSquare() {
        return square;
    }

    public double getSquareOfFurniture() {
        return squareOfFurniture;
    }

    public double getIlluminance() {
        return illuminance;
    }

    public int getCountOfWindows() {
        return countOfWindows;
    }


    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setIlluminations(Lamp lamp) throws IlluminanceToMuchException {
        if(lamp.getIlluminance() < 4000) {
            this.lamps.add(new Lamp(lamp.getName(), lamp.getIlluminance()));
            illuminance += lamp.getIlluminance();
        }
        else throw new IlluminanceToMuchException("Лампа слишком мощная");
    }

    public void setFurnitureList(Furniture furniture)throws SpaceUsageTooMuchException {
        if (furniture.getSquare() < (this.square*0.7)) {
            this.squareOfFurniture += furniture.getSquare();
            this.furnitureList.add(new Furniture(furniture.getName(), furniture.getSquare()));
        }
        else throw new SpaceUsageTooMuchException("Объект занимает слишком много места!");
    }

    public void illumInfo(){
        for(Lamp i : lamps){
            System.out.print(", " + i.getIlluminance() + " лк");
        }
    }

    public void furnInfo(){
        for(Furniture f : furnitureList){
            System.out.println(f.getName() + " " + f.getSquare() + " м^2");
        }
    }

}
