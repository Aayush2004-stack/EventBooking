package view;


import controller.EventController;
import model.Event;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class EventView {
    static Scanner input =new Scanner(System.in);
    static EventController eventController =new EventController();

    public static void createEventView(User user) {

        System.out.println("Create an Event!!\n(Note: Event is finalized only after admin approves it!!)\n");
        System.out.println("Enter the title of the event:");
        String eventTitle = input.nextLine();
        double price = 0;
        while(true){
            try {
                System.out.println("Enter the price of the ticket: ");
                price = Double.parseDouble(input.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Please only enter the valid price in digits");
            }
        }

        int availableTickets = 0;
        while(true){
            try {
                System.out.println("Enter the number of tickets to issue: ");
                availableTickets = Integer.parseInt(input.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Please only enter the valid number in digits");
            }

        }

        if(eventController.addEvent(eventTitle, price, availableTickets, user.getUserId())){
            System.out.println("Event added successfully for review\n(NOTE: It takes few minutes to hours to review and confirm the event)\n");
        }
        else {
            System.out.println("Error adding the event\n");
        }

    }

    public static void registerEventView() {
        System.out.println("Register to an Event\n");
        System.out.println("Applicable events: ");

    }
    public static void userEventView(User user){
        ArrayList<Event> eventList =eventController.getAllEvent();
        int i=1;
        String remark;
        for (Event event: eventList){
            if(event.getIssuedUserID()==user.getUserId()){

                if(event.getIsApproved()==null){
                    remark="In Review";
                }
                else if(event.getIsApproved()){
                    remark="Approved";
                } else {
                    remark="Rejected";
                }

                System.out.println("S.N: "+i);
                System.out.println("Event Title :"+event.getTitle());
                System.out.println("Ticket Price: "+event.getPrice());
                System.out.println("Available Tickets: "+event.getAvailableTickets());
                System.out.println("Remarks: "+ remark);
                System.out.println("---------------------------------\n");
                i++;
            }
        }
    }
}
