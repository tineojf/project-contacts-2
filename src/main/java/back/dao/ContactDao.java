package back.dao;

import back.models.Person;
import io.github.cdimascio.dotenv.Dotenv;

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
        Dotenv dotenv = Dotenv.configure().load();
        String dbTable = dotenv.get("DB_TABLE");

        Connection connection = this.connectDB();
        List<Person> persons = new ArrayList<Person>();

        try {
            String query = "SELECT * FROM " + dbTable;
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

    public void postContact(Person pm_person) {
        Dotenv dotenv = Dotenv.configure().load();
        String dbTable = dotenv.get("DB_TABLE");

        Connection connection = this.connectDB();
        String query = "INSERT INTO " + dbTable + " (name, lastname, birthday, email, phone, country) " + "VALUES ('"
                + pm_person.getName() + "', '" + pm_person.getLastname() + "', '"
                + pm_person.getBirthday() + "', '" + pm_person.getEmail() + "', '"
                + pm_person.getPhone() + "', '" + pm_person.getCountry() + "')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            System.out.println("Success");
        } catch (Exception e) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Fail");
        }
    }

    public Person getContactID(String pm_id) {
        Dotenv dotenv = Dotenv.configure().load();
        String dbTable = dotenv.get("DB_TABLE");

        Connection connection = this.connectDB();
        String query = "SELECT * FROM " + dbTable + " WHERE id = '" + pm_id + "' LIMIT 1";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getString("id"));
                person.setName(resultSet.getString("name"));
                person.setLastname(resultSet.getString("lastname"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));
                person.setBirthday(resultSet.getString("birthday"));
                person.setCountry(resultSet.getString("country"));

                resultSet.close();
                statement.close();
                connection.close();
                return person;
            }
        } catch (Exception e) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void deleteContact(String pm_id) {
        Dotenv dotenv = Dotenv.configure().load();
        String dbTable = dotenv.get("DB_TABLE");

        Connection connection = this.connectDB();
        String query = "DELETE FROM " + dbTable + " WHERE id = '" + pm_id + "' LIMIT 1";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            System.out.println("Delete success");
        } catch (Exception e) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Fail");
        }
    }

    public void putContact(Person pm_person) {
        Dotenv dotenv = Dotenv.configure().load();
        String dbTable = dotenv.get("DB_TABLE");

        Connection connection = this.connectDB();
        String query = "UPDATE " + dbTable
                + " SET name = '" + pm_person.getName()
                + "', lastname = '" + pm_person.getLastname()
                + "', birthday = '" + pm_person.getBirthday()
                + "', email = '" + pm_person.getEmail()
                + "', phone = '" + pm_person.getPhone()
                + "', country = '" + pm_person.getCountry()
                + "' WHERE id = '" + pm_person.getId() + "' LIMIT 1";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            System.out.println("Update success");
        } catch (Exception e) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Fail");
        }
    }
}
