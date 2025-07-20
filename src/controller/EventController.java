package controller;

import dao.EventDAO;
import model.Event;

import java.util.ArrayList;


public class EventController {
    EventDAO eventDAO = new EventDAO();

    public boolean addEvent(String eventTitle, double price, int availableTickets, int userId) {
        Event event =new Event(eventTitle,price,availableTickets,userId);
        return eventDAO.addEvent(event);
    }

    public ArrayList<Event> getApprovedEvent() {
        ArrayList<Event>events=eventDAO.getApprovedEvent();
        ArrayList<Event> toRemove = new ArrayList<>();
        if(events!=null){
            for (Event event: events){
                Boolean isApproved=event.getIsApproved();
                if(!isApproved){
                    toRemove.add(event);
                }
            }
            events.removeAll(toRemove);


        }
        return events;
    }
}
