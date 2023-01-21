package com.ecommerce.ecommerce.service;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce.model.entity.Product;

@Service
public interface ProductService {
    Product add(Product request);
    Page<Product> findByAll(int page, int size, String sort, String sortType);
    Product findById(String id);
    Product updateById(String id, Product request);
    Boolean deleteById(String id);
    Boolean updateStatus(String id, boolean isStockReady);
}
