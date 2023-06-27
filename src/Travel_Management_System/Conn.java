package Travel_Management_System;
import java.sql.*;
public class Conn {
    Connection connection;
    Statement statement;
    public Conn(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelManagement","root","979966");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
