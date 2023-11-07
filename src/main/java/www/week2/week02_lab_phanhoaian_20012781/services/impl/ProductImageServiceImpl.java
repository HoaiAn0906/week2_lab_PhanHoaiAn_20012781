package www.week2.week02_lab_phanhoaian_20012781.services.impl;

import jakarta.inject.Inject;
import www.week2.week02_lab_phanhoaian_20012781.models.ProductImage;
import www.week2.week02_lab_phanhoaian_20012781.repositories.ProductImageRepository;
import www.week2.week02_lab_phanhoaian_20012781.services.ProductImageService;

import java.util.List;

public class ProductImageServiceImpl implements ProductImageService {
    @Inject
    private ProductImageRepository productImageRepository;
    @Override
    public List<ProductImage> getAll() {
        return productImageRepository.getAll(ProductImage.class);
    }

    @Override
    public boolean create(ProductImage productImage) {
        return productImageRepository.create(productImage);
    }

    @Override
    public boolean update(ProductImage productImage) {
        return productImageRepository.update(productImage);
    }

    @Override
    public boolean delete(long id) {
        return productImageRepository.delete(id, ProductImage.class);
    }
}
