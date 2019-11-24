package com.skor.alex.epamlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {
    private Connection connection;
    private final String url="jdbc:mysql://localhost/periodicals?serverTimezone=Europe/Minsk&useSSL=false";
    private final String pswd="njhcbjy19";
    private final String username="root";

    public DBController(){
        try {
            connection= DriverManager.getConnection(url,username,pswd);
            System.out.println("Connection established!");
        } catch (SQLException e) {
            System.out.println("Произошла ошибка. База данных недоступна");
        }
    }

    public void Disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка разрыва соединения");
        }
    }

    private void PushData(){

    }

    public void EstablishConnection(){

    }

    public void GetData() throws SQLException {
        String command="USE periodicals";
        Statement statement=connection.createStatement();
        statement.executeUpdate(command);
        command="INSERT INTO data (category,name,type,issue,tags,price,id) VALUES ('cars','Top Gear','Magazine',12,'none',140,241521)";
        statement.executeUpdate(command);
    }
}
