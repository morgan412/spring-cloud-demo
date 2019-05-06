package com.turbosnail.order.client;

import com.turbosnail.order.client.ProductFeignClient;
import com.turbosnail.order.pojo.Product;
import org.springframework.stereotype.Component;

/**
 * @author zouxq
 * @date 2019/5/6
 */
@Component
class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProduct(Long id) {
        Product product = new Product();
        product.setId(-1L);
        product.setName("默认商品");
        return product;
    }
}
