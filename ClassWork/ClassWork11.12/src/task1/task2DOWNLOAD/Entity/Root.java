package task1.task2DOWNLOAD.Entity;

import java.util.List;

public class Root {
    private String name;
    private List<People> people;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Root)) return false;

        Root root = (Root) o;

        if (getName() != null ? !getName().equals(root.getName()) : root.getName() != null) return false;
        return getPeople() != null ? getPeople().equals(root.getPeople()) : root.getPeople() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPeople() != null ? getPeople().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }
}
