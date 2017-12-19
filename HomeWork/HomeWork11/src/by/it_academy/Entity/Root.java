package by.it_academy.Entity;

import java.util.List;

public class Root {
    private  String name;
    private List<People> peoples;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

}
