/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
import Vente.Conct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saif
 */
public class serviceprod  {
     Connection cn=Conct.getInstance().getCnx();
   
     public void ajouterProd(Produit p, int id )  throws SQLException{
 Date dateCourante = new Date();
        DateFormat formatJJMMAAAA = new SimpleDateFormat("dd/MM/yyyy");
        String a=formatJJMMAAAA.format(dateCourante);
        String requet = "insert into produit(Nom,Description,idClient,Prix,Image,Etat,localisation,Date) values ('"+p.getNom()+ "','"+p.getDescription()+"','"+id+"','"+p.getPrix()+"','"+p.getImage()+"','"+p.getEtat()+"','"+p.getLocalisation()+"','"+ a + "');";
        
        try {
            Statement st=cn.createStatement();
            st.executeUpdate(requet);
    }
        
        catch(SQLException ex){
                       System.out.println(ex.getMessage()) ; 

        }
    }
     public void supprimerparID (int id) {
        System.out.print(id);
        try { 
            String query ="DElETE FROM produit WHERE idVelo="+id ; 
            Statement st=cn.createStatement();
            st.executeUpdate(query) ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
                    System.out.println("le produit de l id = "+id+"a ete bien supprimer ") ; 

    }
      
     public List<Produit> getListProd() throws SQLException{
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
     p.setPrix(rs.getString(5));
       p.setImage(rs.getString(6));
     p.setEtat(rs.getString(7));
     p.setLocalisation(rs.getString(8));
   
    list.add(p) ; 
}

        }
catch (SQLException ex) {
                System.out.println(ex.getMessage()) ; 

}
return list ; 
} 
           
     public List<Produit> getListProdC(int id) throws SQLException{
        

List<Produit> list = new ArrayList<>() ; 
String r="select * from Produit where idClient='"+id+"'" ; 
try {
Statement stt=cn.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    Produit p; 
     p = new Produit();
          p.setId(rs.getInt(1));

     p.setNom(rs.getString(2));
     p.setDescription(rs.getString(3));
     p.setPrix(rs.getString(5));
       p.setImage(rs.getString(6));
     p.setEtat(rs.getString(7));
     p.setLocalisation(rs.getString(8));
   
    list.add(p) ; 
}

        }
catch (SQLException ex) {
                    System.out.println(ex.getMessage()) ; 

}
return list ; 
} 
       public List<Produit> RechercherProduit(String nom) throws SQLException{

     List<Produit> listrecherche = new ArrayList<>();
       // UserServices uu=new UserServices();
       
        try {
            String req="SELECT * FROM produit WHERE Nom='"+nom+"'";
Statement stt=cn.createStatement() ; 
ResultSet rs=stt.executeQuery(req);
            while(rs.next())
            {    
            Produit p = new Produit();
          p.setNom(rs.getString(2));
     p.setDescription(rs.getString(3));
     p.setPrix(rs.getString(5));
       p.setImage(rs.getString(6));
     p.setEtat(rs.getString(7));
     p.setLocalisation(rs.getString(8));
         
                listrecherche.add(p);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceprod.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listrecherche;
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
     public void modifierProd (  int id , String nom  , Double prix,String Description,String Localisation,String Image )
{ try {
     String query ="UPDATE Produit SET nom='"+nom+"',Description='"+Description+"',Prix='"+prix+"',Image='"+Image+"',Localisation='"+Localisation+"' WHERE idVelo='"+id+"'";
     Statement st=cn.createStatement();
      st.executeUpdate(query) ;
      System.out.println("Client bien modifié");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
}
