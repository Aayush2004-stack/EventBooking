package view;

import controller.UserController;

import java.util.Scanner;

public class LoginView {
    public static void showLoginView(){
        UserController controller=new UserController();
        Scanner input = new Scanner(System.in);

        while(true){ //to reprompt the username and password if login fails
            System.out.println("Enter your username: ");
            String username= input.nextLine();
            System.out.println("Enter your password: ");
            String password= input.nextLine();

            if(controller.logIn(username,password)){
                System.out.println("Login successful");
                break;
            }
            else {
                System.out.println("Incorrect password");
            }
        }


    }
}
