package www.week2.week02_lab_phanhoaian_20012781.services;


import www.week2.week02_lab_phanhoaian_20012781.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> getAll();

    public boolean create(Product product);

    public boolean update(Product product);

    public boolean delete(long id);

    public Map<String, List<Object>> getChartPriceByTime(long id);
}
