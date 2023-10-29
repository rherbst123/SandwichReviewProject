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
import java.util.ArrayList;
import java.util.Random;


public class PopulateSandwiches {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
            
            Connection conn = DriverManager.getConnection (
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
            
           PreparedStatement p = null;
           ResultSet rs = null;
            
            
            Statement statement = conn.createStatement();
            
           // statement.executeUpdate("INSERT INTO SANDWICH " + "VALUES ('The Clucker', 'Devil Dawgs', 'RiverNorth', 'Pretzel Bun, Spicy Coleslaw, Pickels')");
            statement.executeUpdate("INSERT INTO SANDWICH " + "VALUES ('TheTasty', 'SandwichHut', 'EdgeWater', 'Big but with all the goods')");

            try {
                String sql = "select * from SANDWICH";
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                
                System.out.println("NAME/SHOP/HOOD/DESCRIPTION");
                
                while (rs.next()) {
                    
                    String NAME = rs.getString("NAME");
                    String SHOP = rs.getString("SHOP");
                    String HOOD = rs.getString("HOOD");
                    String DESCRIPTION = rs.getString("DESCRIPTION");
                    System.out.println(NAME + "\t\t" + SHOP + "\t\t" + HOOD + "\t\t" + DESCRIPTION);
                }
            }
            
            catch (SQLException e) {
                System.out.println(e);
            }
    }}
            
           