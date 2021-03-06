package by.it_academy.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private Date lastOrder;
    private Date dateOfBirth;
    @SerializedName("car")
    private List<String> cars;
    @SerializedName("discount")
    private boolean isDiscount;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastOrder() {
        return lastOrder;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public List<String> getCars() {
        return cars;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastOrder(Date lastOrder) {
        this.lastOrder = lastOrder;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (isDiscount != customer.isDiscount) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (lastOrder != null ? !lastOrder.equals(customer.lastOrder) : customer.lastOrder != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(customer.dateOfBirth) : customer.dateOfBirth != null)
            return false;
        return cars != null ? cars.equals(customer.cars) : customer.cars == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastOrder=" + lastOrder +
                ", dateOfBirth=" + dateOfBirth +
                ", cars=" + cars +
                ", isDiscount=" + isDiscount +
                '}';
    }
}
