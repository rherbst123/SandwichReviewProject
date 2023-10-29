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
public class InitUserDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection (
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
            
         //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            System.out.println("If Table Exists... drop it like it's hot");
            try {
                
                String sql = "DROP TABLE USERS";
            
                conn.createStatement().execute(sql);
            
                System.out.println("Table Dropped!");
            } catch (Exception e) {
                System.out.println("Table Didn't Exist");
            }
       
            String sql = " CREATE TABLE USERS (";
            sql = sql + " USER VARCHAR(30) PRIMARY KEY,";
            sql = sql + " PASS VARCHAR(30),";
            sql = sql + " ADMIN BOOLEAN)";
 
            conn.createStatement().execute(sql);
            System.out.println("Table USERS created!");
            System.out.println("DB Complete!");
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
    
    