package www.week2.week02_lab_phanhoaian_20012781.services;



import www.week2.week02_lab_phanhoaian_20012781.models.ProductImage;

import java.util.List;

public interface ProductImageService {
    public List<ProductImage> getAll();

    public boolean create(ProductImage product);

    public boolean update(ProductImage product);

    public boolean delete(long id);
}
