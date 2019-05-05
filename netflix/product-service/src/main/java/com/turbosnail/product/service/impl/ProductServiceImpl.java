package com.turbosnail.product.service.impl;

import com.turbosnail.product.pojo.Product;
import com.turbosnail.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zou
 * @date 2019/5/1
 */
@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product((long) 1, "秋裤", "花秋裤", new BigDecimal("9.9"), 99));
        return products;
    }

    @Override
    public Product get(Long id) {
        for (Product product : getProducts()) {
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
}
