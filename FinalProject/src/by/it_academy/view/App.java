package by.it_academy.view;

import by.it_academy.controller.Manager;

public class App {
    public static void main(String [] args){
UI ui = new UIImplement();
Manager.getInstance().setUi(ui);
ui.downloadAndParse();
ui.mainMenu();
    }
}
