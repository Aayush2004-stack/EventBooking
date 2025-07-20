package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public boolean logIN(User user) {
        boolean logIn=false;
        try {
            conn=DataBaseConnection.connection();
            if(conn!=null){
                String query="Select * FROM user where username = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, user.getUsername());
                ResultSet resultSet =ps.executeQuery();
                if(resultSet.next()){
                    String username= resultSet.getString("username");
                    String password= resultSet.getString("password");
                    String name= resultSet.getString("name");
                    Boolean isAdmin=resultSet.getBoolean("isAdmin");
                    if(password.equals(user.getPassword())){
                        user.setName(name);
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setAdmin(isAdmin);
                        logIn=true;
                    }
                }

            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return logIn;
    }
}
