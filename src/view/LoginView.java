package view;

import controller.UserController;
import model.User;

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

            User user=controller.logIn(username,password);

            if(user!=null){
                System.out.println("Login successful\n");
                if(user.getAdmin()){
                    AdminView.showAdminView(user);
                }
                else{
                    UserView.showUserView(user);
                }
                break;
            }
            else {
                System.out.println("Incorrect password\n");
            }
        }


    }
}
