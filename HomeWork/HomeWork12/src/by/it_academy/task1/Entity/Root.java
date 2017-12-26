package by.it_academy.task1.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.text.SimpleDateFormat;
import java.util.Date;
        import java.util.List;

public class Root {
    private String name;
    @JsonProperty (value = "people")
    private List<People> peoples;
    private Gender gender;
    private Date date;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Root)) return false;

        Root root = (Root) o;

        if (getName() != null ? !getName().equals(root.getName()) : root.getName() != null) return false;
        if (getPeoples() != null ? !getPeoples().equals(root.getPeoples()) : root.getPeoples() != null) return false;
        if (getGender() != root.getGender()) return false;
        return getDate() != null ? getDate().equals(root.getDate()) : root.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPeoples() != null ? getPeoples().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }

@Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Root{\n" +
                "name='" + name + '\'' +
                ",\n gender=" + gender +
                ",\n date=" + sdf.format(date) +
                ",\n people=" + peoples +
                '}';
    }
}
