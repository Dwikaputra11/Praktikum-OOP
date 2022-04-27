package com.tutorial.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/tugasjdbc";
    String DBusername = "root";
    String DBpassword = "";
    public Connection con;
    public Statement statement;
    public Connector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
}
