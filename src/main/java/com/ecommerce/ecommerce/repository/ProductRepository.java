package com.ecommerce.ecommerce.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ecommerce.ecommerce.model.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {
    
}
