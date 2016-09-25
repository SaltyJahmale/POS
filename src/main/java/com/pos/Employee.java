package com.pos;

import lombok.Data;

/**
 * Created by dewi on 19.09.16.
 */
@Data
public class Employee {

    private String name;
    private int id;
    private boolean loggedIn;


    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }


}
