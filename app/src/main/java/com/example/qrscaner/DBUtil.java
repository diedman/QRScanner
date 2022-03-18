package com.example.qrscaner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static Connection conn;
    private static final String ADDRESS  = "jdbc:mysql://185.251.91.163:3306/";
    private static String dbName         = "Practic";
    private static final String USERNAME = "dedman";
    private static final String PASSWORD = "Hdleo#-Yeb45";
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection changeDatabase(String newDBName) {
        dbName = newDBName;
        return getConnection();
    }

    public static Connection getConnection() {
        try{
            conn = DriverManager.getConnection(ADDRESS + dbName, USERNAME, PASSWORD);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
