package view;

import java.util.Scanner;

public class SignUpView {
    public static void showSignUpView(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name or the company name");
        String name= scan.nextLine();
        System.out.println("Enter username: ");
        String username = scan.nextLine();
        System.out.println("Enter password: ");
        String password = scan.nextLine();
        //TODO pass the username and password to insert in the db

    }
}
