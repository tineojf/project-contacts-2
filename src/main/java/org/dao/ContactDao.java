package org.dao;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactDao {
    public Connection connectDB() {
        Dotenv dotenv = Dotenv.configure().load();

        String dbHost = dotenv.get("DB_HOST");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbPort = dotenv.get("DB_PORT");
        String dbDatabase = dotenv.get("DB_DATABASE");
        String driver = "com.mysql.cj.jdbc.Driver";

        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbDatabase + "?user="
                + dbUser + "&password=" + dbPassword + "&useSSL=false&allowPublicKeyRetrieval=true";

        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            //System.out.println("Successfull connection");
            return connection;
        } catch (Exception e) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error connection");
            return null;
        }
    }
}
