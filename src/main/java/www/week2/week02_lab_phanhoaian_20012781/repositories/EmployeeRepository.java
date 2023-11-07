package www.week2.week02_lab_phanhoaian_20012781.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import www.week2.week02_lab_phanhoaian_20012781.models.Employee;

import java.util.List;

public class EmployeeRepository extends BaseRepository<Employee> {

    public List<Employee> getAll() {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Employee> employees = session.createNamedQuery("Employee.findAll", Employee.class)
                .getResultList();
        transaction.commit();
        return employees;
    }
}
