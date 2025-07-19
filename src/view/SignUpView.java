package view;

import controller.UserController;

import java.util.Scanner;

public class SignUpView {
    public static void showSignUpView(){

        while(true){
            UserController controller = new UserController();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your name or the company name");
            String name= scan.nextLine();
            System.out.println("Enter username: ");
            String username = scan.nextLine();
            System.out.println("Enter password: ");
            String password = scan.nextLine();


            if(controller.SignUp(name, username, password)){
                System.out.println("SignUp successful\n");
                break;
            }
            else {
                System.out.println("Error, please try again\n");
            }

        }


    }
}
