/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rileyproject.theproject.dbstuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author riley
 */
public class PopulateUser {

   public static void main(String[] args) throws SQLException {
        
            
            Connection conn = DriverManager.getConnection (
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
            
           PreparedStatement p = null;
           ResultSet rs = null;
            
            
            Statement statement = conn.createStatement();
            
            statement.executeUpdate("INSERT INTO USERS " + "VALUES ('CarterShimp', 'Alsk1029', '1')");
            
            try {
                String sql = "select * from USERS";
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                
                System.out.println("USER/PASS/ADMIN");
                
                while (rs.next()) {
                    
                    String USER = rs.getString("USER");
                    String PASS = rs.getString("PASS");
                    String ADMIN = rs.getString("ADMIN");
                    
                    System.out.println(USER + "\t\t" + PASS + "\t\t" + ADMIN );
                }
            }
            
            catch (SQLException e) {
                System.out.println(e);
            }
    }}
            
           