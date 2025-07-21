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
    public boolean approveEvent(Event event){
        return eventDAO.approveEvent(event);
    }
    public boolean rejectEvent(Event event){
        return eventDAO.rejectEvent(event);
    }

    public ArrayList<Event> getAllEvent(){
        return eventDAO.getEvent();
    }

    public ArrayList<Event> getApprovedEvent() {
        ArrayList<Event>events=eventDAO.getEvent();
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
    public ArrayList<Event> getToApproveEvent() {
        ArrayList<Event> eventsToApprove =eventDAO.getEvent();
        ArrayList<Event> toRemove = new ArrayList<>();
        if(eventsToApprove !=null){
            for (Event event: eventsToApprove){
                Boolean isApproved=event.getIsApproved();
                if(isApproved!=null){
                    toRemove.add(event);
                }
            }
            eventsToApprove.removeAll(toRemove);
        }
        return eventsToApprove;
    }

}
