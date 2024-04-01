package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection {

    public static java.sql.Connection getConnection() throws SQLException, IOException {
        Properties properties = new Properties();

        String url;
        String userName;
        String password;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\dhund\\IntelliJWorkSpace\\Connection\\src\\main\\resources\\sql.properties");
            properties.load(file);
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }


        return DriverManager.getConnection(url, userName, password);


    }
}
