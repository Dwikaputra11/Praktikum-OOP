package login.registration.database;

import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.*;
import javax.swing.JOptionPane;
import login.registration.screen.Login;

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
    public boolean insertData(String username, String password) throws SQLException{
        try{
            if(username.isEmpty()) throw new Exception("Please Input Your Username!"); 
            else if(password.isEmpty()) throw new Exception("Please Input Your Password!");
            else{
                statement = con.createStatement();
                String query = "SELECT * FROM users";
                ResultSet rs = statement.executeQuery(query);
                boolean isExist;
                while(rs.next()){
                    String nama = rs.getString("username");
                    if(nama.equals(username)) return false;
                }
                query = "insert into users(username, password) values (?,?)";
                PreparedStatement prepareStatement = con.prepareStatement(query);
                prepareStatement.setString(1, username);
                prepareStatement.setString(2, password);
                prepareStatement.executeUpdate();
                return true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage() , "Alert", HEIGHT);
        }
        con.close();
        return false;
    }
    public boolean selectData(String username, String password){
        try{
            if(username.isEmpty()) throw new Exception("Please Input Your Username!"); 
            else if(password.isEmpty()) throw new Exception("Please Input Your Password!");
            else{
                statement = con.createStatement();
                String query = "SELECT * FROM users";
                ResultSet rs = statement.executeQuery(query);
                
                while(rs.next()){
                    String nama = rs.getString("username");
                    String pass = rs.getString("password");
                    if(nama.equals(username) && pass.equals(password)) return true;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage() , "Alert", HEIGHT);
        }
        return false;
    }
}
