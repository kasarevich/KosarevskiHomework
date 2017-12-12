package by.it_academy.task2.Realization;

import by.it_academy.task2.Building;

public class InfoManager {
    public void showInfo(Building building){
        System.out.println("\t\t" + building.getName());
        System.out.println("_________________________");
        for(int i=0; i < building.getRooms().size(); i++) {
            System.out.println("\t" + building.getRooms().get(i).getName());
            System.out.print("Освещенность = " + building.getRooms().get(i).getIlluminance());
            System.out.print(" (Окна : " + building.getRooms().get(i).getCountOfWindows() + " шт. по 700 лк ," +
                    " Лампы: " + building.getRooms().get(i).getFurnitureList().size());
            building.getRooms().get(i).illumInfo();
            System.out.println(")");
            System.out.println("Площадь = " + building.getRooms().get(i).getSquare() + "м^2");
            System.out.println("Свободно " + (building.getRooms().get(i).getSquare() - building.getRooms().get(i).getSquareOfFurniture()) + " м^2, или " + (100 - (building.getRooms().get(i).getSquareOfFurniture()*100/building.getRooms().get(i).getSquare())) + "% площади");
            building.getRooms().get(i).furnInfo();
            System.out.println("_________________________");
        }
    }

}


