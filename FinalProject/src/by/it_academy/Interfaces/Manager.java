package by.it_academy.Interfaces;

import by.it_academy.Entity.Station;

public interface Manager {
    public void connect(UI ui);
    public Station parseXML(UI ui);
    public Station parseJSON(UI ui);
}
