package com.turbosnail.product.rest;

import com.turbosnail.product.pojo.Product;
import com.turbosnail.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zou
 * @date 2019/5/1
 */
@RestController
public class ProductRest {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
        Product product= productService.get(id);
        System.out.println(product);
        return product;
    }
}
