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
public class PopulateReview {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
       
        
        Connection conn = DriverManager.getConnection (
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
            
           PreparedStatement p = null;
           ResultSet rs = null;
            
            
            Statement statement = conn.createStatement();
            
           // statement.executeUpdate("INSERT INTO SANDWICH " + "VALUES ('The Clucker', 'Devil Dawgs', 'RiverNorth', 'Pretzel Bun, Spicy Coleslaw, Pickels')");
            statement.executeUpdate("INSERT INTO REVIEW " + "VALUES ('TheTasty', 'SandwichHut', 'CarterShimp', 'damn thats good', '5')");

            try {
                String sql = "select * from REVIEW";
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                
                System.out.println("NAME/SHOP/USER/REVIEW/STARS");
                
                while (rs.next()) {
                    
                    String NAME = rs.getString("NAME");
                    String SHOP = rs.getString("SHOP");
                    String USER = rs.getString("USER");
                    String REVIEW = rs.getString("REVIEW");
                    String STARS = rs.getString("STARS");
                    System.out.println(NAME + "\t\t" + SHOP + "\t\t" + USER + "\t\t" + REVIEW + "\t\t" + STARS);
                }
            }
            
            catch (SQLException e) {
                System.out.println(e);
            }
    }}


       