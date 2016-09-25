package com.pos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by dewi on 19.09.16.
 */
@Data
@AllArgsConstructor
public class Product {
    private String digitcode;
    private double price;
    private ProductSpec productSpec;

}
