package front;

import back.dao.ContactDao;
import back.models.Person;

import java.util.List;
import java.util.Scanner;

public class Options {
    public void getPerson() {
        ContactDao contactDao = new ContactDao();
        List<Person> listContacts = contactDao.getContacts();

        for (Person element : listContacts) {
            System.out.println(element);
        }
    }

    public void createPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the lastname: ");
        String lastname = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter the country: ");
        String country = scanner.nextLine();
        System.out.println("Enter the birthday: ");
        String birthday = scanner.nextLine();

        Person person = new Person("id", name, lastname, email, phone, country, birthday);
        ContactDao contactDao = new ContactDao();
        contactDao.postContact(person);
    }

    public void getPersonID(String id) {
        ContactDao contactDao = new ContactDao();
        Person person = contactDao.getContactID(id);

        if (person != null) {
            System.out.println("----------------------------------------");
            System.out.println("Contact: #" + person.getId());
            System.out.println("Name:     " + person.getName());
            System.out.println("Lastname: " + person.getLastname());
            System.out.println("Email:    " + person.getEmail());
            System.out.println("Phone:    " + person.getPhone());
            System.out.println("Country:  " + person.getCountry());
            System.out.println("Birthday: " + person.getBirthday());
            System.out.println("----------------------------------------");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("No contact found for ID: " + id);
            System.out.println("----------------------------------------");
        }
    }

    public void deletePersonID(String id) {
        ContactDao contactDao = new ContactDao();
        contactDao.deleteContact(id);
    }
}
