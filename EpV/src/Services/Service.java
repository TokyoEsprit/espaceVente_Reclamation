/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Vente.Conct;
import Entities.client;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Saif
 */
public class Service {
    
    Connection cn=Conct.getInstance().getCnx();
     
    public void ajouterClient(client c) throws SQLException {
  
        String requet="insert into client (Nom,Prenom,Adress) values ('"+c.getPrenom()+ "','"+c.getNom()+"','"+c.getAdress()+"')" ; 
          
        try {
            Statement st=cn.createStatement();
             
            st.executeUpdate(requet);
               System.out.println("co") ; 
            System.out.println("ajoutee") ; 
    }
        
        catch(SQLException ex){
                       System.out.println(ex.getMessage()) ; 

        }
    }
    
    public void supprimerparID (int id) {
        
        try { 
            String query ="DElETE FROM client WHERE idClient="+id ; 
            Statement st=cn.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("le client de l id = "+id+"a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
      
   public List<client> getListclient(){
List<client> list = new ArrayList<>() ; 
String r="select * from client" ; 
try {
Statement stt=cn.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    client cl; 
    cl = new client();
      cl.setIdClient(rs.getInt(1));
    cl.setNom(rs.getString(2));
    cl.setPrenom(rs.getString(3));
        cl.setAdress(rs.getString(4));
    
    list.add(cl) ; 
    
    
    
}

        }
catch (SQLException ex) {
    
}
return list ; 
} 

public void modifiercl (  int idClient , String nom ,String Prenom , String Adress)
{ try {
     String query ="UPDATE client SET nom='"+nom+"',Prenom='"+Prenom+"',Adress='"+Adress+"' WHERE idClient='"+idClient+"'";
     Statement st=cn.createStatement();
      st.executeUpdate(query) ;
      System.out.println("Client bien modifié");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
public client chercherclParId ( int id )
{                      client c = new client();

    try { 
            String query ="SELECT * FROM client WHERE idClient='"+id+"'" ; 
            Statement st=cn.createStatement();
    ResultSet rst = st.executeQuery(query);

          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                c.setNom(rst.getString("Nom"));
                c.setPrenom(rst.getString("Prenom"));
          } else {
                  System.out.println("le client n'est pas trouvé ") ; 
          }
              
        
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    return c;
}


public void chercherclParNom ( String nom )
{  try { 
            String query ="SELECT * FROM client WHERE nom='"+nom+"'" ; 
            Statement st=cn.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("le client est trouvé ") ; 
          } else {
                  System.out.println("le client n'est pas trouvé ") ; 
          }
              
        
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
}