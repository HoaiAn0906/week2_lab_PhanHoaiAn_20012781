package www.week2.week02_lab_phanhoaian_20012781.services.impl;

import jakarta.inject.Inject;
import www.week2.week02_lab_phanhoaian_20012781.models.Employee;
import www.week2.week02_lab_phanhoaian_20012781.repositories.EmployeeRepository;
import www.week2.week02_lab_phanhoaian_20012781.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    public boolean create(Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public boolean delete(long id) {
        return employeeRepository.delete(id, Employee.class);
    }
}
