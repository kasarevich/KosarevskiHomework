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
    public void showAll(){
        System.out.println("Имя файла: " + name);
        System.out.println("|\tID\t|\tИмя\t|\tФамилия\t|\t\tВозраст\t|\tСтатус\t|");
        for(People p : peoples){
            System.out.println("_____________________________________________________________");
            System.out.println("|\t" + p.getId() + "\t|\t" + p.getName() + "\t|\t" + p.getSurname() + "\t|\t\t" + p.getAge() + "\t\t|\t" + p.isDegree() +"\t| ");
        }
    }

}
