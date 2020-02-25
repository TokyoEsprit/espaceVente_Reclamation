/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Saif
 */
public class Conct {
    String url="jdbc:Mysql://localhost:3308/velo1" ;
    Connection cnx; 
    String Login="root"; 
    String Password="" ; 
    static Conct cn ; 
    
   private Conct() {
       try {
       
     cnx =DriverManager.getConnection(url, Login, Password);
     System.out.println("connected") ; 
       } catch (SQLException ex) {
                      System.out.println(ex.getMessage()) ; 

       }
       
    }
   public Connection getCnx() {
       return cnx ; 
   }
   public static Conct getInstance()  {
       if (cn==null) {
           cn=new Conct() ; 
       }
     return cn ; 
       
   }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
