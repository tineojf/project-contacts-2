package tineo;

import back.models.Person;
import front.Options;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Options options = new Options();

        System.out.println("----------------------------------------");
        System.out.println("Project Contacts");
        System.out.println("Language: Java");
        System.out.println("----------------------------------------");

        System.out.println("1. Create a new contact");
        System.out.println("2. List all contacts");
        System.out.println("3. Exit");

        System.out.println("----------------------------------------");
        System.out.println("Enter an option: ");
        int option = scanner.nextInt();
//        System.out.println("Option: " + option);
        System.out.println("----------------------------------------");

        switch (option) {
            case 1:
                System.out.println("Create a new contact");
                options.createPerson();
                break;
            case 2:
                System.out.println("List all contacts");
                options.getPerson();

                System.out.println("Type the item id to view a contact (0 to back): ");
                String id = scanner.next();

                if (id.equals("0")) {
                    break;
                }

                // Print contact info
                Person choicePerson = options.getPersonID(id);

                System.out.println("1) Edit");
                System.out.println("2) Delete");
                System.out.println("3) Back");
                String option2 = scanner.next();

                switch (option2) {
                    case "1":
                        System.out.println("Edit");
                        options.putPersonID(choicePerson);
                        break;
                    case "2":
                        System.out.println("Delete");
                        options.deletePersonID(id);
                        break;
                    case "3":
                        System.out.println("Back");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}
