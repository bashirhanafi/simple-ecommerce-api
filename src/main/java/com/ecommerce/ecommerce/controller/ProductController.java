package com.ecommerce.ecommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.ecommerce.model.entity.Product;
import com.ecommerce.ecommerce.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    ProductService productService;
    
    // INSERT PRODUCT
    // host:{port}/product/add
    @PostMapping("/add")
    private Product add(@RequestBody Product request) {
        return productService.add(request);
    }

    // GET ALL PRODUCT
    // host:{port}/product/all
    @GetMapping("/all")
    private Page<Product> findByAll(
    @RequestParam(defaultValue = "0") int page, 
    @RequestParam(defaultValue = "10") int size, 
    @RequestParam(defaultValue = "price") String sort, 
    @RequestParam(defaultValue = "asc") String sortby) {
        return productService.findByAll(page, size, sort, sortby);
    }

    // GET PRODUCT BY ID
    // host:{port}/product/{id}
    @GetMapping("/{id}")
    private Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    // UPDATE PRODUCT BY ID
    // host:{port}/product/update/{id}
    @PutMapping("/update/{id}")
    private Product updateById(@PathVariable String id, @RequestBody Product request) {
        return productService.updateById(id, request);
    }

    // DELETE PRODUCT BY ID
    // host:{port}/product/delete/{id}
    @DeleteMapping("/delete/{id}")
    private Boolean deleteById(@PathVariable String id) {
        return productService.deleteById(id);
    }

    // UPDATE PRODUCT STOCK BY ID
    // host:{port}/product/update-status/{id}
    @PatchMapping("/update-status/{id}")
    private boolean updateStatus(@PathVariable String id, @RequestParam boolean isStockReady) {
        return productService.updateStatus(id, isStockReady);
    }
}
