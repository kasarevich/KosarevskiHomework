package by.it_academy.task2;

import by.it_academy.task2.Realization.InfoManager;
import by.it_academy.task2.Realization.RoomManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String []args){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            RoomManager roomManager = new RoomManager();
            InfoManager infoManager = new InfoManager();
            Building building = new Building("Офис");
            boolean ok = true;
            while (ok) {
                System.out.println("\t\t Введите:");
                System.out.println("\t1 - для добавления комнаты в здание");
                System.out.println("\t2 - для просмотра информации o комнатах");

                try {
                    int num = Integer.parseInt(reader.readLine());
                    switch (num) {
                        case 1: {
                            roomManager.addRoom(building);
                            break;
                        }
                        case 2: {
                            infoManager.showInfo(building);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e.toString());
                } catch (NumberFormatException e) {
                    System.out.println(e.toString());
                }


            }
        }
}


