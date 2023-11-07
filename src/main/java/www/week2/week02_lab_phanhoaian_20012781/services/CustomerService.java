package www.week2.week02_lab_phanhoaian_20012781.services;

import www.week2.week02_lab_phanhoaian_20012781.models.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();

    public boolean create(Customer customer);

    public boolean update(Customer customer);

    public boolean delete(long id, Class<Customer> customerClass);
}
