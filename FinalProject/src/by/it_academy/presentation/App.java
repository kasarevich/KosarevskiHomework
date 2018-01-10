package by.it_academy.presentation;

import by.it_academy.domain.interfaces.UI;

public class App {
    public static void main(String [] args){
UI ui = new UIImplement();
ui.download();
ui.parseFile();
ui.mainMenu();
    }
}
