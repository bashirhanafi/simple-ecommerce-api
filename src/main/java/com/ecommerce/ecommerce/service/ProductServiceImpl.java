package com.ecommerce.ecommerce.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce.model.entity.Product;
import com.ecommerce.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product add(Product request) {
        if(request.getStock() > 0) {
            request.setIsStockReady(true);
        } else {
            request.setIsStockReady(false);
        }
        productRepository.save(request);
        return request;
    }

    @Override
    public Page<Product> findByAll(int page, int size, String sort, String sortType) {
        PageRequest request = null;

        if(sortType.equalsIgnoreCase("asc")) {
            request = PageRequest.of(page, size, Sort.by(sort).ascending());
        } else if(sortType.equalsIgnoreCase("dsc")) {
            request = PageRequest.of(page, size, Sort.by(sort).descending());
        }

        Page<Product> result = productRepository.findAll(request);
        return result;
    }

    @Override
    public Product findById(String id) {
        Product result = productRepository.findByIdCustom(id);

        if(result!=null) {
            return result;
        } else {
            return null;
        }
    }

    @Override
    public Product updateById(String id, Product request) {
        Optional<Product> result = productRepository.findById(id);
        if(result.isPresent()) {
            result.get().setName(request.getName());
            result.get().setPrice(request.getPrice());
            result.get().setStock(request.getStock());
            result.get().setWeight(request.getWeight());
            result.get().setDescription(request.getDescription());
            result.get().setIsStockReady(request.getIsStockReady());
            return productRepository.save(request);
        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteById(String id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateStatus(String id, boolean isStockReady) {
        final Optional<Product> result = productRepository.findById(id);
        if(result.isPresent()) {
            Product product = result.get();
            product.setIsStockReady(isStockReady);
            productRepository.save(product);
            return true;
        } else {
            return false;
        }
    }
}
