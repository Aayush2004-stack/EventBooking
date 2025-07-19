package view;

import java.util.Scanner;

public class MainView {
    public static void showMainView(){
        Scanner input = new Scanner(System.in);

        boolean exit =false;
        while(!exit){
            System.out.println("Enter 1 to SignUp");
            System.out.println("Enter 2 to LogIN");
            System.out.println("Enter 3 to Exit\n");
            try{
                int userChoice=Integer.parseInt(input.nextLine());//holod the user choice

                switch (userChoice){
                    case 1:
                        SignUpView.showSignUpView();
                        break;
                    case 2:
                        LoginView.showLoginView();
                        break;
                    case 3:
                        System.out.println("Thank you for using the program\n");
                        exit =true;
                        break;
                    default:
                        System.out.println("Please enter the valid option only\n");
                }

            } catch (RuntimeException e) {
                System.out.println("Please enter the valid option only\n");
            }
        }

    }
}
