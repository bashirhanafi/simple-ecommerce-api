package com.ecommerce.ecommerce.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.model.entity.Product;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Product findByIdCustom(String id) {
        Product product = mongoTemplate.findById(id, Product.class);
        return product;
    }
}
