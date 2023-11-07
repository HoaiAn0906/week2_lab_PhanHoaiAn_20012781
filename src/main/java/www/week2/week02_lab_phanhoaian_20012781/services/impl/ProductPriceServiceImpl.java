package www.week2.week02_lab_phanhoaian_20012781.services.impl;

import jakarta.inject.Inject;
import www.week2.week02_lab_phanhoaian_20012781.models.ProductPrice;
import www.week2.week02_lab_phanhoaian_20012781.repositories.ProductPriceRepository;
import www.week2.week02_lab_phanhoaian_20012781.services.ProductPriceService;

import java.util.List;

public class ProductPriceServiceImpl implements ProductPriceService {
    @Inject
    private ProductPriceRepository productPriceRepository;
    @Override
    public List<ProductPrice> getAll() {
        return productPriceRepository.getAll(ProductPrice.class);
    }

    @Override
    public boolean create(ProductPrice productPrice) {
        return productPriceRepository.create(productPrice);
    }

    @Override
    public boolean update(ProductPrice productPrice) {
        return productPriceRepository.update(productPrice);
    }

    @Override
    public boolean delete(long id) {
        return productPriceRepository.delete(id, ProductPrice.class);
    }
}
