package www.week2.week02_lab_phanhoaian_20012781.services.impl;

import jakarta.inject.Inject;
import www.week2.week02_lab_phanhoaian_20012781.models.OrderDetail;
import www.week2.week02_lab_phanhoaian_20012781.repositories.OrderDetailRepository;
import www.week2.week02_lab_phanhoaian_20012781.services.OrderDetailService;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Inject
    private OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepository.getAll(OrderDetail.class);
    }

    @Override
    public boolean create(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(long id, Class<OrderDetail> orderDetailClass) {
        return false;
    }
}
