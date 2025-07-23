package view;

import controller.TicketController;
import model.Ticket;
import model.User;

import java.util.ArrayList;

public class TicketView {

    public static void userTicketView(User user) {
        TicketController ticketController =new TicketController();
        System.out.println("The tickets of the event you registered are displayed below: ");
        ArrayList<Ticket> tickets=ticketController.getTickets(user);
        int i =1;
        for (Ticket ticket: tickets){
            System.out.println("S.N: "+ i);
            System.out.println("Ticket No: "+ticket.getTicketNo());
            System.out.println("Event Id: "+ticket.getEventId());
            i++;
        }


    }
}
