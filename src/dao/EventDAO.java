package dao;

import model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
