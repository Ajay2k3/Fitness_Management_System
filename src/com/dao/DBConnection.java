package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {

        try {

            Properties props = new Properties();

            InputStream input =
                    DBConnection.class.getClassLoader()
                    .getResourceAsStream("database.properties");

            props.load(input);

            url = props.getProperty("db.url");

            user = props.getProperty("db.user");

            password = props.getProperty("db.password");

            driver = props.getProperty("db.driver");

            Class.forName(driver);

            System.out.println("Database Connected");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    url, user, password);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}