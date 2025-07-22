package view;

import model.User;

import java.util.Scanner;

public class UserView {
    public static void showUserView(User user){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome back "+user.getName()+"\n");
        boolean logged =true;
        while(logged){
            System.out.println("Enter 1 to create an Event");
            System.out.println("Enter 2 to register to an Event");
            System.out.println("Enter 3 to see my Events");
            System.out.println("Enter 4 to see my tickets");
            System.out.println("Enter 5 to logout");
            try {
                int userChoice=Integer.parseInt(input.nextLine());
                switch (userChoice){
                    case 1:
                        EventView.createEventView(user);
                        break;
                    case 2:
                        EventView.registerEventView();
                        break;
                    case 3:
                        EventView.userEventView(user);
                        break;
                    case 4:
                        TicketView.userTicketView(user);
                        break;
                    case 5:
                        System.out.println("Logging out");
                        logged=false;
                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid choice");
            }
        }


    }
}
