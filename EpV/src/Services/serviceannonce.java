/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.annonce;
import Vente.Conct;

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
public class serviceannonce {
    
     Connection cn=Conct.getInstance().getCnx();
   
     public void ajouterAnnonce(annonce a, int idc ) {
        
        String requet = "insert into annonce(type,commentaire,idC) values ('"+a.getType()+ "','"+a.getCommentaire()+"','"+idc+"')" ; 
        
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
            String query ="DElETE FROM annonce WHERE idA="+id ; 
            Statement st=cn.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("l'annonce de l id = "+id+"a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
      
     public List<annonce> getListAnnonce(){
List<annonce> list = new ArrayList<>() ; 
String r="select * from annonce" ; 
try {
Statement stt=cn.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    annonce aa; 
    aa= new annonce();
      aa.setId(rs.getInt(1));
    aa.setType(rs.getString(2));
   aa.setCommentaire(rs.getString(3));
        aa.setIdC(rs.getInt(4));
       
    list.add(aa) ; 
       
}
        }
catch (SQLException ex) {    
}
return list ; 

} 
     public void chercherclParType( String type)
{  try { 
            String query ="SELECT * FROM annonce WHERE type='"+type+"'" ; 
            Statement st=cn.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("l'annoce est trouvée ") ; 
          } else {
                  System.out.println("l'annonce n'est pas trouvée") ; 
          }
              
        
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}
     public void modifierAnnonce (  int id , String type  , String commentaire )
{ 
    try {
     String query ="UPDATE annonce SET type='"+type+"',commentaire='"+commentaire+"' WHERE idA='"+id+"'" ;
     
  
     Statement st=cn.createStatement();
      st.executeUpdate(query) ;
      System.out.println("Annonce bien modifiée");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
    
    
}
