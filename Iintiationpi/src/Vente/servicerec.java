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

/**
 *
 * 
 */
public class servicerec {
    Connection cn=Conct.getInstance().getCnx();

    public void ajouterRec(int idCl ,recEvent r ) {
        
   recEvent rc; 
    rc = new recEvent();

        List<recEvent> list = new ArrayList<>() ; 

        String requet = "insert into recevent(type,contenu,etat,idCl) values ('"+r.getType()+ "','"+r.getContenu()+"','"+r.getEtat()+"','"+idCl+"')" ; 
                String requet2 = "select * from recevent where (SELECT max(idR) from recevent) " ; 


        try {
            
            
            Statement st=cn.createStatement();
                
            Statement stt=cn.createStatement();
                        Statement sttt=cn.createStatement();

            st.executeUpdate(requet);
            
            ResultSet rs=stt.executeQuery(requet2); 
            while(rs.next()) {
      rc.setId(rs.getInt(1));
            }
   System.out.print(rc.getId());
            String requett = "insert into reclamation(contenu,etat,type,idRe) values ('"+r.getContenu()+ "','"+r.getEtat()+"','"+r.getType()+"','"+rc.getId()+"')" ; 

            sttt.executeUpdate(requett);

    }
        
        catch(SQLException ex){
                       System.out.println(ex.getMessage()) ; 

        }
    } 
    public void supprimerparID (int id) {
        
        try { 
            String query ="DElETE FROM recevent WHERE idR="+id ; 
            String queryy ="DElETE FROM reclamation WHERE idRe="+id ; 
            Statement st=cn.createStatement();
             Statement stt=cn.createStatement();
            st.executeUpdate(query) ;
            stt.executeUpdate(queryy) ;
            System.out.println("la rec  de l id = "+id+"a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
       public List<recEvent> getListEvent(){
List<recEvent> list = new ArrayList<>() ; 
String r="select * from recevent" ; 
try {
Statement stt=cn.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
  recEvent rc; 
    rc = new recEvent();
      rc.setId(rs.getInt(1));
    rc.setType(rs.getString(2));
   rc.setContenu(rs.getString(3));
        rc.setEtat(rs.getString(4));
    
    list.add(rc) ; 
    
    
    
}

        }
catch (SQLException ex) {
    
}
return list ; 
} 
    
}
