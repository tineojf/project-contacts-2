package tineo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                break;
            case 2:
                System.out.println("List all contacts");
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
