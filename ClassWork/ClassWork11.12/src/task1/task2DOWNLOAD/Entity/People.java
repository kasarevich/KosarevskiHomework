package task1.task2DOWNLOAD.Entity;

public class People {

    private int id;
    private String name;
    private String surname;
    private int age;
    private boolean isDegree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public void setDegree(boolean degree) {
        isDegree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        if (getId() != people.getId()) return false;
        if (getAge() != people.getAge()) return false;
        if (isDegree() != people.isDegree()) return false;
        if (getName() != null ? !getName().equals(people.getName()) : people.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(people.getSurname()) : people.getSurname() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (isDegree() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", isDegree=" + isDegree +
                '}';
    }
}
