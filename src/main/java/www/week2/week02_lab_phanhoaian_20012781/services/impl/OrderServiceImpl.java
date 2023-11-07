package www.week2.week02_lab_phanhoaian_20012781.services.impl;

import jakarta.inject.Inject;
import www.week2.week02_lab_phanhoaian_20012781.models.Order;
import www.week2.week02_lab_phanhoaian_20012781.repositories.OrderRepository;
import www.week2.week02_lab_phanhoaian_20012781.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll(Order.class);
    }

    @Override
    public boolean create(Order order) {
        return false;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(long id, Class<Order> orderClass) {
        return false;
    }
}
