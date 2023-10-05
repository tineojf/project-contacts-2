package org.dao;

import io.github.cdimascio.dotenv.Dotenv;
import org.models.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactDao {
    private Connection connectDB() {
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

    public List<Person> getContacts() {
        Connection connection = this.connectDB();
        List<Person> persons = new ArrayList<Person>();

        try {
            String query = "SELECT * FROM persons";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getString("id"));
                person.setName(resultSet.getString("name"));
                person.setLastname(resultSet.getString("lastname"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));
                person.setBirthday(resultSet.getString("birthday"));
                person.setCountry(resultSet.getString("country"));
                persons.add(person);
            }

            resultSet.close();
            statement.close();
            connection.close();
            return persons;
        } catch (Exception e) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
