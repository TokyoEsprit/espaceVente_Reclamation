/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;


public class Produit {
    
    int id ; 
    String Nom ; 
    String Image ; 
    Double Prix ; 
    String Description ; 


    public Produit() {
    }

    public Produit(String Nom, String Image, Double Prix, String Description) {
        this.Nom = Nom;
        this.Image = Image;
        this.Prix = Prix;
        this.Description = Description;
    }

    public Produit(String Nom, Double Prix, String Description) {
        this.Nom = Nom;
        this.Prix = Prix;
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public Double getPrix() {
        return Prix;
    }

    public void setPrix(Double Prix) {
        this.Prix = Prix;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

   
}
