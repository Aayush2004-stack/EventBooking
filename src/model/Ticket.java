package model;

public class Ticket {
    int ticketNo;
    int eventNo;

    public Ticket(int ticketNo, int eventId) {
        this.ticketNo = ticketNo;
        this.eventNo = eventId;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public int getEventId() {
        return eventNo;
    }

    public void setEventId(int eventId) {
        this.eventNo = eventId;
    }
}
