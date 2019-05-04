package com.turbosnail.order.controller;

import com.turbosnail.order.pojo.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author zou
 * @date 2019/5/1
 */
@RestController
@Log4j2
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
        return restTemplate.getForObject("http://product-service/product/" + id, Product.class);
    }

    @GetMapping("/product/log/{id}")
    public void logProduct(@PathVariable Long id){
        ServiceInstance serviceInstance = loadBalancerClient.choose("product-service");
        URI storesUri = URI.create(String.format("https://%s:%s/"+ id, serviceInstance.getHost(), serviceInstance.getPort()));
        log.info("{}:{}:{}", serviceInstance.getInstanceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
