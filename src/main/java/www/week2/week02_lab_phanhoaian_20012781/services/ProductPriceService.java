package www.week2.week02_lab_phanhoaian_20012781.services;


import www.week2.week02_lab_phanhoaian_20012781.models.ProductPrice;

import java.util.List;

public interface ProductPriceService {
    public List<ProductPrice> getAll();

    public boolean create(ProductPrice productPrice);

    public boolean update(ProductPrice productPrice);

    public boolean delete(long id);
}
