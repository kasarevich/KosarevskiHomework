package by.it_academy.view;

import by.it_academy.controller.interfaces.UI;

public class App {
    public static void main(String [] args){
UI ui = new UIImplement();
ui.downloadAndParse();
ui.mainMenu();
    }
}
