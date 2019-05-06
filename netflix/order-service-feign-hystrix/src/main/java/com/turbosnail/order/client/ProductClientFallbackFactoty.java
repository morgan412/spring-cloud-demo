package com.turbosnail.order.client;

import com.turbosnail.order.pojo.Product;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author zouxq
 * @date 2019/5/6
 */
@Component
@Log4j2
public class ProductClientFallbackFactoty implements FallbackFactory<ProductFeignClient> {
    @Override
    public ProductFeignClient create(Throwable throwable) {
        return new ProductFeignClient() {
            @Override
            public Product getProduct(Long id) {
                // 日志最好放在各个 fallback 方法中，而不要直接放在 create 方法中
                // 否则在引用启动时会打印该日志
                log.info("fallback, caused by:", throwable);
                Product product = new Product();
                product.setId(-1L);
                product.setName("默认商品");
                return product;
            }
        };
    }
}
