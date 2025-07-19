package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    Connection conn = null;

    public boolean signUp(User user) {
        boolean userInserted =false;
        try {
            conn=(DataBaseConnection.connection());
            if(conn!=null){
                String query ="INSERT INTO user (username, password, name) VALUES (?, ?, ?)";
                PreparedStatement ps =conn.prepareStatement(query);
                ps.setString(1,user.getUsername());
                ps.setString(2,user.getPassword());
                ps.setString(3,user.getName());
                int row = ps.executeUpdate();
                if(row>0){
                   userInserted =true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return userInserted;


    }
}
