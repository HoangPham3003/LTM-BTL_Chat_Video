/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hoang Pham
 */
public class ConfigDB {
    // Config
    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "127.0.0.1";
        String dbName = "BTLLTM";
        String userName = "kitkat";
        String password = "0988083998aA@";

        return getMySQLConnection(hostName, dbName, userName, password);
    }
    
    // Create connection
    public static Connection getMySQLConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/"
                + dbName + "?zeroDateTimeBehavior=convertToNull";

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}
