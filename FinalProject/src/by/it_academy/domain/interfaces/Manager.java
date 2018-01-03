package by.it_academy.domain.interfaces;

import by.it_academy.domain.entity.Station;

public interface Manager {
    public void connect(UI ui);
    public Station parseXML(UI ui);
    public Station parseJSON(UI ui);
}
