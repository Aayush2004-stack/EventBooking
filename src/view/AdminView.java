package view;

import controller.EventController;
import model.Event;
import model.User;

import java.util.Scanner;

public class AdminView {
    public  static void showAdminView(User user){
        Scanner input=new Scanner(System.in);
        EventController eventController =new EventController();
        System.out.println("Welcome Back "+user.getName());
        boolean logged=true;
        while(logged){
            System.out.println("Enter 1 to see the approved events");
            System.out.println("Enter 2 to see the events to be approved");
            System.out.println("Enter 3 to logout");

            try{
                int userChoice = Integer.parseInt(input.nextLine());

                switch (userChoice){
                    case 1:
                      //call approved events to display
                        int i=1;
                        for(Event event: eventController.getApprovedEvent()){
                            System.out.println("S.N: " +i);
                            System.out.println("Event Id: "+event.getEventId());
                            System.out.println("Event Title: "+event.getTitle());
                            System.out.println("Ticket Price: "+event.getPrice());
                            System.out.println("Available Tickets: "+event.getAvailableTickets());
                            System.out.println("---------------------------------\n");
                            i++;
                        }
                        break;



                    case 2:
                        //call events to be approved display
                    case 3:
                        System.out.println("Logging out");
                        logged=false;
                        break;

                    default:
                        System.out.println("Please enter a valid choice");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Please enter the valid choice");
            }

        }




    }
}
