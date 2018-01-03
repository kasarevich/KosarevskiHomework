package by.it_academy.interfaces;

import by.it_academy.entity.Station;

public interface Manager {
    public void connect(UI ui);
    public Station parseXML(UI ui);
    public Station parseJSON(UI ui);
}
