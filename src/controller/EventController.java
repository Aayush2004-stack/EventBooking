package controller;

import dao.EventDAO;
import model.Event;

public class EventController {
    EventDAO eventDAO = new EventDAO();

    public boolean addEvent(String eventTitle, double price, int availableTickets, int userId) {
        Event event =new Event(eventTitle,price,availableTickets,userId);
        return eventDAO.addEvent(event);
    }
}
