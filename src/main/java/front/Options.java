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

    public Person getPersonID(String id) {
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
            return person;
        } else {
            System.out.println("----------------------------------------");
            System.out.println("No contact found for ID: " + id);
            System.out.println("----------------------------------------");
            return null;
        }
    }

    public void deletePersonID(String id) {
        ContactDao contactDao = new ContactDao();
        contactDao.deleteContact(id);
    }

    public void putPersonID(Person pm_person) {
        ContactDao contactDao = new ContactDao();
        Scanner scanner = new Scanner(System.in);

        // Input new data
        System.out.println("Enter the new name (old: " + pm_person.getName() + "): ");
        String name = scanner.nextLine();
        System.out.println("Enter the lastname (old: " + pm_person.getLastname() + "): ");
        String lastname = scanner.nextLine();
        System.out.println("Enter the email (old: " + pm_person.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone (old: " + pm_person.getPhone() + "): ");
        String phone = scanner.nextLine();
        System.out.println("Enter the country (old: " + pm_person.getCountry() + "): ");
        String country = scanner.nextLine();
        System.out.println("Enter the birthday (old: " + pm_person.getBirthday() + "): ");
        String birthday = scanner.nextLine();

        // Set new data
        if (!name.equals("")) {
            pm_person.setName(name);
        }
        if (!lastname.equals("")) {
            pm_person.setLastname(lastname);
        }
        if (!email.equals("")) {
            pm_person.setEmail(email);
        }
        if (!phone.equals("")) {
            pm_person.setPhone(phone);
        }
        if (!country.equals("")) {
            pm_person.setCountry(country);
        }
        if (!birthday.equals("")) {
            pm_person.setBirthday(birthday);
        }

        contactDao.putContact(pm_person);
    }
}
