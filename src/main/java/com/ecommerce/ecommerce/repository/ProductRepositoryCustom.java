package com.ecommerce.ecommerce.repository;
import com.ecommerce.ecommerce.model.entity.Product;

public interface ProductRepositoryCustom {
    Product findByIdCustom(String id);
}
