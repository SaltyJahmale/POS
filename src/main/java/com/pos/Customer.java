package com.pos;

import lombok.Data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by dewi on 20.09.16.
 */
@Data
public class Customer {

    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

}
