package com.ecommerce.ecommerce.model.entity;
import java.text.SimpleDateFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    
    private String createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    private String name;
    private double price;
    private Integer stock;
    private double weight;
    private String description;
    private Boolean isStockReady = null;
}
