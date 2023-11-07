package www.week2.week02_lab_phanhoaian_20012781.services;

import www.week2.week02_lab_phanhoaian_20012781.models.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();

    public boolean create(Employee employee);

    public boolean update(Employee employee);

    public boolean delete(long id);
}
