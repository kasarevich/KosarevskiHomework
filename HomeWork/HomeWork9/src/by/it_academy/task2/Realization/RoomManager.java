package by.it_academy.task2.Realization;

import by.it_academy.task2.Building;
import by.it_academy.task2.Exceptions.IlluminanceToLittleException;
import by.it_academy.task2.Exceptions.IlluminanceToMuchException;
import by.it_academy.task2.Exceptions.SpaceUsageTooMuchException;
import by.it_academy.task2.Furniture;
import by.it_academy.task2.Illumination.Lamp;
import by.it_academy.task2.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoomManager {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void addRoom(Building building)throws IOException{
        try {
            String name;
            double square;
            int countOfWindow;
            System.out.println("1. Введите название комнаты:");
            name = reader.readLine();
            System.out.println("2. Введите площадь комнаты:");
            square = Double.parseDouble(reader.readLine());
            System.out.println("3. Введите количество окон:");
            countOfWindow = Integer.parseInt(reader.readLine());
                Room room = new Room(name, square, countOfWindow);

            System.out.println("Добавить лампу? 1 - да");
            if (Integer.parseInt(reader.readLine()) == 1) {
                addLamps(room);
            }

            System.out.println("Добавить мебель? 1 - да");
            if (Integer.parseInt(reader.readLine()) == 1) {
                addFurniture(room);
            }

            if(room.getIlluminance() < 300){
                throw new IlluminanceToLittleException("Ошибка! комнате нет источников света!");// последняя проверка перед добавлением комнаты в здание
            }

            building.setRooms(room); // добавляем в список комнат

        }catch (IlluminanceToMuchException e) {
            System.out.println(e.getMessage());
        }catch (SpaceUsageTooMuchException e){
            System.out.println(e.getMessage());
        }catch (IlluminanceToLittleException e){
            e.getMessage();
        }

    }



    public void addLamps(Room room)throws IOException, IlluminanceToMuchException{
        boolean ok = true;
        do{
            System.out.println("Введите модель:");
            String nameOfLamp = reader.readLine();
            System.out.println("Введите количество люкс:");
            int light = Integer.parseInt(reader.readLine());
            Lamp lamp = new Lamp(nameOfLamp, light);
            room.setIlluminations(lamp);
            if(room.getIlluminance() > 4000){
                throw new IlluminanceToMuchException("Превышена допустимая норма освещения");
            }
            System.out.println("Нажмите 1 чтобы добавить лампу.\nНа данный момент освещение равно:" + room.getIlluminance());
            if(Integer.parseInt(reader.readLine()) != 1)
                ok = false;
        }while(ok == true);
    }



    public void addFurniture(Room room)throws IOException, SpaceUsageTooMuchException{
        boolean ok = true;
        do{
            System.out.println("Введите название:");
            String nameOfFurniture = reader.readLine();
            System.out.println("Введите занимаемую площадь:");
            double square = Double.parseDouble(reader.readLine());
            Furniture furniture = new Furniture(nameOfFurniture, square);
            room.setFurnitureList(furniture);
            if (room.getSquareOfFurniture() > room.getSquare()*0.7){
                throw new SpaceUsageTooMuchException("Площадь, занимаемая мебелью, превысила 70% свободного места!");
            }
            System.out.println("Нажмите 1 чтобы добавить мебель.\nНа данный момент занимаемая площадь:" + room.getSquareOfFurniture());
            System.out.println("Занято " +room.getSquareOfFurniture()*100/room.getSquare() + "% площади комнаты");
            if(Integer.parseInt(reader.readLine()) != 1)
                ok = false;
        }while(ok == true);
    }
}
