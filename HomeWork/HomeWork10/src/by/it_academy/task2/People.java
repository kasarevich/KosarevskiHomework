package by.it_academy.task2;

public class People {
    private String fio;

    public People(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return fio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        return fio != null ? fio.equals(people.fio) : people.fio == null;
    }

    @Override
    public int hashCode() {
        return fio != null ? fio.hashCode() : 0;
    }
}

