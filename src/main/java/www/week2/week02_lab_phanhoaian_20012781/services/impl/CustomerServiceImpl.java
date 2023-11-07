package www.week2.week02_lab_phanhoaian_20012781.services.impl;

import jakarta.inject.Inject;
import www.week2.week02_lab_phanhoaian_20012781.models.Customer;
import www.week2.week02_lab_phanhoaian_20012781.repositories.CustomerRepository;
import www.week2.week02_lab_phanhoaian_20012781.services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Inject
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll(Customer.class);
    }

    @Override
    public boolean create(Customer customer) {
        return customerRepository.create(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public boolean delete(long id, Class<Customer> customerClass) {
        return customerRepository.delete(id, Customer.class);
    }
}
