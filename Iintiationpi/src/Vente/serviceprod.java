/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import static Vente.Conct.cn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saif
 */
public class serviceprod {
     Connection cn=Conct.getInstance().getCnx();
   
     public void ajouterProd(Produit p, int id ) {
        
        String requet = "insert into produit(Nom,Prix,Description,idClient) values ('"+p.getNom()+ "','"+p.getPrix()+"','"+p.getDescription()+"','"+id+"')" ; 
        
        try {
            Statement st=cn.createStatement();
            st.executeUpdate(requet);
    }
        
        catch(SQLException ex){
                       System.out.println(ex.getMessage()) ; 

        }
    }
     public void supprimerparID (int id) {
        
        try { 
            String query ="DElETE FROM produit WHERE idVelo="+id ; 
            Statement st=cn.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("le produit de l id = "+id+"a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
      
     public List<Produit> getListProd(){
List<Produit> list = new ArrayList<>() ; 
String r="select * from Produit" ; 
try {
Statement stt=cn.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    Produit p; 
    p = new Produit();
      p.setId(rs.getInt(1));
    p.setNom(rs.getString(2));
   p.setDescription(rs.getString(3));
        p.setPrix(rs.getDouble(4));
    
    list.add(p) ; 
}

        }
catch (SQLException ex) {
    
}
return list ; 
} 
     public void chercherclParNom ( String nom )
{  try { 
            String query ="SELECT * FROM Produit WHERE nom='"+nom+"'" ; 
            Statement st=cn.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("le produit est trouvé ") ; 
          } else {
                  System.out.println("le Produit n'est pas trouvé ") ; 
          }
              
        
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}
     public void modifierProd (  int id , String nom  , Double prix,String Description  )
{ try {
     String query ="UPDATE Produit SET nom='"+nom+"',Description='"+Description+"',Prix='"+prix+"' WHERE idVelo='"+id+"'";
     Statement st=cn.createStatement();
      st.executeUpdate(query) ;
      System.out.println("Client bien modifié");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
}
