package by.it_academy.task1;

import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private Date date;

    public Student(String name, String surname, Date date) {
        this.name = name;
        this.surname = surname;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
