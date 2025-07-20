package model;

public class Event {
    private String title;
    private double price;
    private int availableTickets;
    private int issuedUserID;

    public Event(String title, double price, int availableTickets, int issuedUserID) {
        this.title = title;
        this.price = price;
        this.availableTickets = availableTickets;
        this.issuedUserID = issuedUserID;
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

