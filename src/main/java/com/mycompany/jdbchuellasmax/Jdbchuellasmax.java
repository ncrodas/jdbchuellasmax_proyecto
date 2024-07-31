package com.mycompany.jdbchuellasmax;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdbchuellasmax {

public static void main(String[] args) {
    String usuario="root";
    String password="";
    String url="jdbc:mysql://localhost:3308/jdbchuellasmax";
    Connection conexion;
    Statement statement;
    ResultSet rs;
    
    try {
        conexion = DriverManager.getConnection(url, usuario, password);
        statement =conexion.createStatement();
        rs = statement.executeQuery("SELECT * FROM mascota");
        while(rs.next()){
            System.out.println(rs.getString("nombre"));
        }
         //Insercion de datos 
            statement.execute("INSERT INTO `mascota` (`id`, `nombre`) VALUES (NULL, 'Bonny');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM mascota");
            while(rs.next()){
               System.out.println(rs.getString("nombre"));
            }
     
            //Actualizacion de datos 
            statement.execute("UPDATE `mascota` SET `nombre` = 'Bonny' WHERE `mascota`.`id` = 4");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM mascota");
            while(rs.next()){
               System.out.println(rs.getString("nombre"));
            }
            //Borrar datos 
            statement.execute( "DELETE FROM mascota WHERE `mascota`.`id` = 1");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM mascota");
            while(rs.next()){
               System.out.println(rs.getString("nombre"));
            }
            
            
            
            
        
    } catch (SQLException ex) {
        Logger.getLogger(Jdbchuellasmax.class.getName()).log(Level.SEVERE, null, ex);
    }   
        
   }

}
