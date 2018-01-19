package by.it_academy.model.entity;

import java.util.List;

    public class Station {
        String name;
        String location;
        List<Customer> customers;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public List<Customer> getCustomers() {
            return customers;
        }

        public void setCustomers(List<Customer> customers) {
            this.customers = customers;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Station)) return false;

            Station stations = (Station) o;

            if (getName() != null ? !getName().equals(stations.getName()) : stations.getName() != null) return false;
            if (getLocation() != null ? !getLocation().equals(stations.getLocation()) : stations.getLocation() != null)
                return false;
            return getCustomers() != null ? getCustomers().equals(stations.getCustomers()) : stations.getCustomers() == null;
        }

        @Override
        public int hashCode() {
            int result = getName() != null ? getName().hashCode() : 0;
            result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
            result = 31 * result + (getCustomers() != null ? getCustomers().hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Station{" +
                    "name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    ", customers=" + customers +
                    '}';
        }
    }


