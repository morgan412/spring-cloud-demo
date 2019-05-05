package com.turbosnail.order.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author zouxq
 * @date 2019/5/5
 */
@Configuration
@RibbonClient(name = "product-service", configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
