package com.turbosnail.product.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zou
 * @date 2019/5/1
 */
@Data
@AllArgsConstructor
public class Product implements Serializable {

    private Long id;
    private String name;
    private String descriptionl;
    private BigDecimal price;
    private Integer count;
}
