package www.week2.week02_lab_phanhoaian_20012781.services;

import www.week2.week02_lab_phanhoaian_20012781.models.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public List<OrderDetail> getAll();

    public boolean create(OrderDetail orderDetail);

    public boolean update(OrderDetail orderDetail);

    public boolean delete(long id, Class<OrderDetail> orderDetailClass);
}
