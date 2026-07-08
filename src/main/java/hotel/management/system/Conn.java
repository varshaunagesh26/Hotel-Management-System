package hotel.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement stmt;

    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","M3g@lodon");
            stmt = c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public PreparedStatement prepareStatement(String query) throws SQLException {
        return c.prepareStatement(query);
    }
}
