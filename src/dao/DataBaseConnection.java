package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String dbName="EventBooking";
    private static final String path="jdbc:mysql://localhost:3306/";
    private static final String username="root";
    private static final String password="";

    public  static Connection connection() throws ClassNotFoundException, SQLException {
        Connection conn =null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(path+dbName, username, password);
        return conn;
    }
}
