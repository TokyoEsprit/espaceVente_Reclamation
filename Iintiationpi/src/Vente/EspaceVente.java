/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saif
 */
public class EspaceVente {


   
    public static void main(String[] args) throws SQLException {
      
        Conct c= Conct.getInstance() ; 
        client u=new client("kh","Nawel","la marsa") ; 
        Service s = new Service() ; 
        Produit p =new Produit("velo",580.00,"velo tayaraaa") ; 
        serviceprod sr = new serviceprod(); 
/********************************/ // Client
       //s.ajouterClient(u);
        //s.supprimerparID(11);
       // s.chercherclParId(1);
       //s.chercherclParNom("Nawel");
       // s.modifiercl(10, "Asma","az", "kef");

        
        
        /**************/ //Produit
                
         // sr.ajouterProd(p,3);
        //sr.supprimerparID(2); 
       // sr.chercherclParNom("velooo");
      //sr.modifierProd(6, "daraja", 20.00, "ettyyr");
        servicerec src = new servicerec() ; 
      
        //recEvent ce = new recEvent("eventt" ," bggg", "non traité");
        //src.ajouterRec(1,ce);
        //src.supprimerparID(37);
        
        
        
        /*******************************************************/ //Annonce 
        
        
        serviceannonce sra = new serviceannonce () ; 
        annonce an = new annonce("organisation ","foire bike"); 
       // sra.ajouterAnnonce(an, 3);
        //sra.chercherclParType("organisation");
        //sra.modifierAnnonce(3, "org", "declenchement"); 
        
        /*************************************/ //Avis
        
        serviceavis av = new serviceavis(); 
        Avis avi = new Avis ("commande",3,"tres bien") ;
        //av.ajouterAvis(avi);
       // av.supprimerparID(2);
        //av.chercherclParType("commande");
        //av.modifierAvis(3, "livraison", "mal organ");
        
        
        /******************************/ // reccommande 
        
        servicereccom rcc = new servicereccom() ; 
        
         recCommande cee = new recCommande("rc commande" ," retard", "non traité");
       // rcc.ajouterRec(3,cee);
        // rcc.supprimerparID(2);
        
        
List<client> L=new ArrayList<>() ; 
L=s.getListclient();
for(client e :L) {
    System.out.println("id ="+e.getIdClient()+"  Prenom = "+e.getPrenom()+" Nom = "+e.getNom()+"  adress = "+e.getAdress()) ; 
}
  List<Produit> M=new ArrayList<>() ; 
M=sr. getListProd(); 
for(Produit v:M) {
    System.out.println("id ="+v.getId()+"  Nom= "+v.getNom()+" prix= "+v.getPrix()+"  Description "+v.getDescription()) ; 
}
 List<recEvent> R=new ArrayList<>() ; 
R=src.getListEvent(); 
for(recEvent r:R) {
    System.out.println("id ="+r.getId()+"  type= "+r.getType()+" contenu= "+r.getContenu()+"  etat = "+r.getEtat()) ; 
}
List<annonce> A=new ArrayList<>() ; 
A=sra.getListAnnonce(); 
for(annonce a:A) {
    System.out.println("id ="+a.getId()+"  type= "+a.getType()+" commentaire= "+a.getCommentaire()+"  idC = "+a.getIdC()) ; 
}
List<Avis> Av=new ArrayList<>() ; 
Av=av.getListAvis(); 
for(Avis a:Av) {
    System.out.println("id ="+a.getId()+"  type= "+a.getType()+" Evaluation= "+a.getEvaluation()+"  idC = "+a.getIdC()) ; 
}
      List<recCommande> Rm=new ArrayList<>() ; 
 Rm=rcc.getListreccmd();
for(recCommande a:Rm) {
  System.out.println("id ="+a.getId()+"  type= "+a.getType()+" contenu= "+a.getContenu()+"  etat = "+a.getEtat()) ; 
}
    }
  
    }

    
    
  
     

