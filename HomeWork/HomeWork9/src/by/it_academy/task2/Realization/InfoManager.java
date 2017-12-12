package by.it_academy.task2.Realization;

import by.it_academy.task2.Building;
import by.it_academy.task2.Illumination.Illumination;
import by.it_academy.task2.Room;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InfoManager {
    public void showInfo(Building building){
        System.out.println("\t\t" + building.getName());
        for(int i=0; i < building.getRooms().size(); i++) {
            System.out.println("\t" + building.getRooms().get(i).getName());
            System.out.println("Освещенность = " + building.getRooms().get(i).getIlluminance());
            System.out.print("(" + building.getRooms().get(i).getCountOfWindows() + "окон по 700 лк, " + building.getRooms().get(i).getIlluminations(););
            building.getRooms().get(i).illumInfo();
            System.out.println("Площадь = " + building.getRooms().get(i).getSquare() + "м^2");
            System.out.println("Свободно " + (building.getRooms().get(i).getSquare() - building.getRooms().get(i).getSquareOfFurniture()) + " м^2, или " + (100 - (building.getRooms().get(i).getSquareOfFurniture()*100/building.getRooms().get(i).getSquare())) + "% площади");
            building.getRooms().get(i).furnInfo();
            System.out.println("_________________________");
        }
    }

}


