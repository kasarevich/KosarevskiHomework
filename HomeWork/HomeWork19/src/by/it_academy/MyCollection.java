package by.it_academy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCollection <Staff, Department> implements MyCollectionContract<Staff, Department> {
    private Staff director;
    private Map<Department, List<Staff>> departments = new HashMap<>();

    public void setDirector(Staff director){
        this.director = director;
    }

    @Override
    public Staff getDirector() {
        return director;
    }

    @Override
    public void removeDirector() {
        director = null;
    }

    @Override
    public void addDepartment(Department department) {
        departments.put(department, new ArrayList<Staff>());
    }

    @Override
    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    @Override
    public void addStaff(Staff staff, Department department) {
        this.departments.get(department).add(staff);
    }

    @Override
    public void removeStaff(Staff staff, Department department) {
        this.departments.get(department).remove(staff);
    }

    @Override
    public void moveStaff(Staff staff, Department departmentIn, Department departmentOut) {
       /* departments.get(departmentOut).remove(staff);
        departments.get(departmentIn).add(staff);*/

        removeStaff(staff, departmentOut);
        addStaff(staff, departmentIn);
    }
}
