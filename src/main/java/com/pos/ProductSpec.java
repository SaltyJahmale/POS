package com.pos;

import lombok.Data;

/**
 * Created by dewi on 19.09.16.
 */
@Data
public class ProductSpec {

    private String name;
    private String description;

    public ProductSpec(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
