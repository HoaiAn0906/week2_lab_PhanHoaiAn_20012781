package www.week2.week02_lab_phanhoaian_20012781.services;

import www.week2.week02_lab_phanhoaian_20012781.models.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAll();

    public boolean create(Order order);

    public boolean update(Order order);

    public boolean delete(long id, Class<Order> orderClass);
}
