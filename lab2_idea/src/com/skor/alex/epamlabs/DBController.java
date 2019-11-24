package com.skor.alex.epamlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skor.alex.epamlabs.Periodical;

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

    public void PushData(List<Periodical> data){
        String command="";
        try {
            Statement statement=connection.createStatement();

        for(Periodical temp:data){
            command="INSERT INTO data"+"(category,name,type,issue,tags,price,id) VALUES ('"+temp.getCategory()
                    +"','"+temp.getName()+"','"+temp.getType()+"',"+temp.getIssue()+",'"+temp.getTags()+"',"+
                    temp.getPrice()+","+temp.getID()+")";
            statement.executeUpdate(command);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
