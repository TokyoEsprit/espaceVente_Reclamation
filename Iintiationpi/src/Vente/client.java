/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

/**
 *
 * @author Saif
 */
public class client {
   int idClient ; 
   String nom ; 
   String Prenom ; 
   String Adress ; 
  // produit p =new produit [] ; 

    public client(String nom, String Prenom, String Adress) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.Adress = Adress;
    }
    
 public client(int idClient,String nom, String Prenom, String Adress) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.Adress = Adress;
    }
    client() {
       
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    
 
   
       
}
