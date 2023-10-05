package org.tineo;

import io.github.cdimascio.dotenv.Dotenv;


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

        Dotenv dotenv = Dotenv.configure().load();
        String dbHost = dotenv.get("DATABASE");
        System.out.println(dbHost);
    }
}
