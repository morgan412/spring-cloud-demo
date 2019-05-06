package com.turbosnail.order.client;

import com.turbosnail.order.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zouxq
 * @date 2019/5/5
 */
//@FeignClient(value = "product-service", fallback = ProductFeignClientFallback.class)
@FeignClient(value = "product-service", fallbackFactory = ProductClientFallbackFactoty.class)
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable Long id);
}
