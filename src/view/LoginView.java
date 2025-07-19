package view;

import java.util.Scanner;

public class LoginView {
    public static void showLoginView(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username= input.nextLine();
        System.out.println("Enter your password: ");
        String password= input.nextLine();

        //TODO pass the username and password to match the credentials
    }
}
