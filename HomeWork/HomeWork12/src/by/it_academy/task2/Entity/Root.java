package by.it_academy.task2.Entity;

import java.util.Date;
import java.util.List;

public class Root {

    private String name;
    private Gender gender;
    private Date date;
    private List<People> peoples;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Root)) return false;

        Root root = (Root) o;

        if (getName() != null ? !getName().equals(root.getName()) : root.getName() != null) return false;
        if (getGender() != root.getGender()) return false;
        if (getDate() != null ? !getDate().equals(root.getDate()) : root.getDate() != null) return false;
        return getPeoples() != null ? getPeoples().equals(root.getPeoples()) : root.getPeoples() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getPeoples() != null ? getPeoples().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Root{\n" +
                "name='" + name + '\'' +
                ",\n gender=" + gender +
                ",\n date=" + date +
                ",\n peoples=" + peoples +
                '}';
    }
}
