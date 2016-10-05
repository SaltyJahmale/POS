package com.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dewi on 05.10.16.
 */
public class DataHandler {

    public DataHandler() {

    }

    private String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/XE";
    private String userid = "steve";
    private String password = "0000";
    Connection connection;

    public void getDBConnection() throws SQLException {
        
        connection = DriverManager.getConnection(jdbcUrl, userid, password);
        System.out.println("Connected to db");
    }

}
