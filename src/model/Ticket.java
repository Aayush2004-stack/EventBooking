package model;

public class Ticket {
    int ticketNo;
    int eventId;
    int userId;

    public Ticket(int ticketNo, int eventId) {
        this.ticketNo = ticketNo;
        this.eventId = eventId;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
