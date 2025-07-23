package controller;

import dao.TicketDAO;
import model.Ticket;
import model.User;

import java.util.ArrayList;

public class TicketController {
    TicketDAO ticketDAO=new TicketDAO();
    public ArrayList<Ticket> getTickets(User user){
        return ticketDAO.getUserTickets(user);

    }
    public boolean butTicket(int eventId, int userId){
        return ticketDAO.insertTicket(eventId, userId);
    }
}
