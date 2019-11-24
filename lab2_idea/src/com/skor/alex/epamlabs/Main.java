package com.skor.alex.epamlabs;

import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        if(XMLValidator.ValidateXML())
            System.out.println("The XML file is valid");
        else
            System.out.println("The XML file is invalid");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println("An error occured");;
        }
        DBController dbController=new DBController();
        try {
            dbController.GetData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbController.Disconnect();
        StartParsing();
    }

    private static void StartParsing(){
        XMLParser parser=new XMLParser();
        parser.ParseXML("E:\\Лабы_5сем\\ВТ\\lab2\\lab2\\bin\\com\\skor\\alex\\lab2\\MyShema.xml");

    }
}
