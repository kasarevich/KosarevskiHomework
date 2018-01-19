package Generics.patternIterator;

public interface MyCollectionContract<Staff, Department> {
    void setDirector(Staff director);
    Staff getDirector();
    void removeDirector();

    void addDepartment(Department department);
    void removeDepartment(Department department);

    void addStaff(Staff staff, Department department);
    void removeStaff(Staff staff, Department department);

    void moveStaff(Staff staff, Department departmentIn, Department departmentOut);

}
