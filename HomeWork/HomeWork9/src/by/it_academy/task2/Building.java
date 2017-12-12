package by.it_academy.task2;

import by.it_academy.task2.Exceptions.IlluminanceToMuchException;

import java.util.LinkedList;
import java.util.List;

public class Building {
    private String name;
    private List<Room> rooms = new LinkedList<>();

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Room room){
        this.rooms.add(room);
    }
}
