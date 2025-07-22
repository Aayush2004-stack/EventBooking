package dao;

import model.Ticket;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketDAO {
    private Connection conn =null;
    public ArrayList<Ticket> getUserTickets(User user) {
        ArrayList<Ticket>tickets=new ArrayList<>();
        try {
            conn=DataBaseConnection.connection();
            if(conn!=null){
                String query="SELECT * FROM tickets WHERE userId =? ";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1,user.getUserId());

                ResultSet resultSet= ps.executeQuery();
                while (resultSet.next()){

                    int ticketNo=resultSet.getInt("ticketNo");
                    int eventId=resultSet.getInt("eventId");
                    Ticket ticket=new Ticket(ticketNo,eventId);
                    tickets.add(ticket);
                }

            }
        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }
        return tickets;

    }
}
