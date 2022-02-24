package com.ander.Database;

import java.sql.*;
import com.ander.Database.Config;

public class Conexion {
    private final Connection client;

    public Conexion() throws SQLException{
            this.client = DriverManager.getConnection(Config.URL.getData(),Config.USER.getData(),Config.PASS.getData());
    }
    public Connection getClient(){
        return this.client;
    }   
    
}