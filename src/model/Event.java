package model;

public class Event {
    private int eventId;
    private String title;
    private double price;
    private int availableTickets;
    private int issuedUserID;
    private Boolean isApproved;

    public Event(String title, double price, int availableTickets, int issuedUserID) {
        this.title = title;
        this.price = price;
        this.availableTickets = availableTickets;
        this.issuedUserID = issuedUserID;
    }

    public Event(int eventId, String title, double price, int availableTickets, Boolean isApproved ) {
        this.title = title;
        this.price = price;
        this.availableTickets = availableTickets;
        this.eventId=eventId;
        this.isApproved=isApproved;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public int getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public int getIssuedUserID() {
        return issuedUserID;
    }

    public void setIssuedUserID(int issuedUserID) {
        this.issuedUserID = issuedUserID;
    }
}

