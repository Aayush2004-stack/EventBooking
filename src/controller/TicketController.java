package controller;

import dao.TicketDAO;
import model.Ticket;
import model.User;

import java.util.ArrayList;

public class TicketController {
    TicketDAO ticketDAO=new TicketDAO();
    public ArrayList<Ticket> getTicekts(User user){
        return ticketDAO.getUserTickets(user);

    }
}
