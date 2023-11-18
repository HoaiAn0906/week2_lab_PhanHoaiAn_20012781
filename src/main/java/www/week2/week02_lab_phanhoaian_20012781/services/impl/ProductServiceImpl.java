package www.week2.week02_lab_phanhoaian_20012781.services.impl;

import jakarta.inject.Inject;
import www.week2.week02_lab_phanhoaian_20012781.models.Product;
import www.week2.week02_lab_phanhoaian_20012781.repositories.ProductRepository;
import www.week2.week02_lab_phanhoaian_20012781.services.ProductService;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.getAll(Product.class);
    }

    @Override
    public boolean create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(long id) {
        return productRepository.delete(id, Product.class);
    }

    @Override
    public Map<String, List<Object>> getChartPriceByTime(long id) {
        return productRepository.getChartPriceByTime(id);
    }
}
