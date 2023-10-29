/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rileyproject.theproject.dbstuff;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author riley
 */
public class InitReviewDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    try {
            Connection conn = DriverManager.getConnection (
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
            
            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            System.out.println("If Table Exists... drop it like it's hot");
            try {
                
                String sql = "DROP TABLE REVIEW";
            
                conn.createStatement().execute(sql);
            
                System.out.println("Table Dropped!");
            } catch (Exception e) {
                System.out.println("Table Didn't Exist");
            }

            
           
            String sql = "CREATE TABLE REVIEW (";
            sql = sql + " NAME VARCHAR(30),";
            sql = sql + " SHOP VARCHAR(30),";
            sql = sql + " USER VARCHAR(30),";
            sql = sql + " REVIEW VARCHAR(500),";
            sql = sql + " STARS DOUBLE,";
            sql = sql + " FOREIGN KEY (NAME) REFERENCES SANDWICH(NAME),";
            sql = sql + " FOREIGN KEY (USER) REFERENCES USERS (USER),";
            sql = sql + " PRIMARY KEY (NAME, USER))";
            
//            String sql2 = " CREATE TABLE SANDWICH (";
//            sql2 = sql2 + " NAME VARCHAR(50),";
//            sql2 = sql2 + " SHOP VARCHAR(50),";
//            sql2 = sql2 + " HOOD VARCHAR(50),";
//            sql2 = sql2 + " DESCRIPTION VARCHAR(500),";
//            sql2 = sql2 + " PRIMARY KEY (NAME, SHOP))";
//            
//                String sql3 = " CREATE TABLE USERS (";
//            sql3 = sql3 + " USER VARCHAR(30) PRIMARY KEY,";
//            sql3 = sql3 + " PASS VARCHAR(30),";
//            sql3 = sql3 + " ADMIN BOOLEAN)";


      
            
            
            
            
            
            
            conn.createStatement().execute(sql);
            System.out.println("Table REVIEW created!");
            System.out.println("DB Complete!");
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
    
    

