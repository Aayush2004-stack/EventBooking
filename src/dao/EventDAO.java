package dao;

import model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDAO {

    private Connection conn =null;
    public boolean addEvent(Event event) {
        try {
            conn =DataBaseConnection.connection();
            if(conn!=null){
                String query="INSERT INTO events (title, price, availableTickets, issuedUserId) VALUES (?, ?, ?, ?)";
                PreparedStatement ps =conn.prepareStatement(query);
                ps.setString(1, event.getTitle());
                ps.setDouble(2, event.getPrice());
                ps.setInt(3, event.getAvailableTickets());
                ps.setInt(4, event.getIssuedUserID());

                int row =ps.executeUpdate();
                if(row>0){
                    return true;
                }
            }
        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean approveEvent(Event event){
        try {
            conn =DataBaseConnection.connection();
            if(conn!=null){
                String query="UPDATE events SET isApproved = 1 WHERE eventId = ?";
                PreparedStatement ps =conn.prepareStatement(query);
                ps.setInt(1, event.getEventId());


                int row =ps.executeUpdate();
                if(row>0){
                    return true;
                }
            }
        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }
    public boolean rejectEvent(Event event){
        try {
            conn =DataBaseConnection.connection();
            if(conn!=null){
                String query="UPDATE events SET isApproved = 0 WHERE eventId = ?";
                PreparedStatement ps =conn.prepareStatement(query);
                ps.setInt(1, event.getEventId());


                int row =ps.executeUpdate();
                if(row>0){
                    return true;
                }
            }
        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }
    public ArrayList<Event> getEvent(){
        ArrayList<Event>events=new ArrayList<>();
        try {
            conn =DataBaseConnection.connection();
            if(conn!=null){
                String query="Select * from events";
                PreparedStatement ps =conn.prepareStatement(query);
                ResultSet resultSet= ps.executeQuery();

                while (resultSet.next()){
                    int eventId= resultSet.getInt("eventId");
                    String title= resultSet.getString("title");
                    int availableTickets = resultSet.getInt("availableTickets");
                    double price =resultSet.getDouble("price");
                    int issuedUserId=resultSet.getInt("issuedUserId");

                    //getBoolean doesn't return wrapper class. only 1 or 0 so used getObject to hold null value too
                    Boolean isApproved=resultSet.getObject("isApproved", Boolean.class);
                    Event event =new Event(eventId,title,price,availableTickets,isApproved,issuedUserId);

                    events.add(event);
                }

            }

        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }
        return events;
    }
}
