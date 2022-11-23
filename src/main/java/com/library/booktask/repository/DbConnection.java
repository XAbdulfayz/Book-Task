package com.library.booktask.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DbConnection {
    private static DbConnection dbConnection;

    public Connection db() {
        try {
            Connection connection = DriverManager.getConnection(PConfig.get("jdbc.driver"), PConfig.get("user.name"), PConfig.get("db.password"));
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static DbConnection getInstance(){
        if (dbConnection ==null){
            return dbConnection =new DbConnection();
        }
        return dbConnection;
    }
}
