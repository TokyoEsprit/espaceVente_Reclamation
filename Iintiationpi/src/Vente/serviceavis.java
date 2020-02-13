/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class serviceavis {
     Connection cn=Conct.getInstance().getCnx();
   
     public void ajouterAvis(Avis a ) {
        
        String requet = "insert into avis(type,idCc,Evaluation) values ('"+a.getType()+ "','"+a.getIdC()+"','"+a.getEvaluation()+"')" ; 
        
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
            String query ="DElETE FROM avis WHERE id="+id ; 
            Statement st=cn.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("l'avis de l id = "+id+"a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
      
     public List<Avis> getListAvis(){
List<Avis> list = new ArrayList<>() ; 
String r="select * from avis" ; 
try {
Statement stt=cn.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    Avis avv; 
    avv= new Avis();
      avv.setId(rs.getInt(1));
    avv.setType(rs.getString(2));
   avv.setIdC(rs.getInt(3));
        avv.setEvaluation(rs.getString(4)); 

       
    list.add(avv) ; 
       
}
        }
catch (SQLException ex) {    
}
return list ; 

} 
     public void chercherclParType( String type)
{  try { 
            String query ="SELECT * FROM Avis WHERE type='"+type+"'" ; 
            Statement st=cn.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("l'avis est trouvée ") ; 
          } else {
                  System.out.println("l'avis n'est pas trouvée") ; 
          }
              
        
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}
     public void modifierAvis(  int id , String type  , String Evaluation  )
{ 
    try {
     String query ="UPDATE avis SET type='"+type+"',Evaluation='"+Evaluation+"' WHERE id='"+id+"'" ;
     
  
     Statement st=cn.createStatement();
      st.executeUpdate(query) ;
      System.out.println("Avis bien modifiée");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
    
}
