package Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Produit {
     Date dateCourante = new Date();
    DateFormat formatJJMMAAAA = new SimpleDateFormat("dd/MM/yyyy");
    String a=formatJJMMAAAA.format(dateCourante);

    int id ; 
    String Nom ; 
    String Image ; 
    String Prix ; 
    String Description ;
    public String  date ; 
    String Email ; 
    
    String Etat ; 
    String Localisation ; 
    ImageView im;



    public Produit() {
    }

    public Produit( String Nom, String Image, String Prix, String Description, String Etat, String Localisation ,String date) {
       Date dateCourante = new Date();
        DateFormat formatJJMMAAAA = new SimpleDateFormat("dd/MM/yyyy");
        String a=formatJJMMAAAA.format(dateCourante);
        this.id = id;
        this.Nom = Nom;
        this.Image = Image;
        this.Prix = Prix;
        this.Description = Description;
        this.Etat = Etat;
        this.Localisation = Localisation;
        this.date=a;
        
    }
    public Produit( String Nom, String Image, String Prix, String Description, String Etat, String Localisation) {
      
        this.id = id;
        this.Nom = Nom;
        this.Image = Image;
        this.Prix = Prix;
        this.Description = Description;
        this.Etat = Etat;
        this.Localisation = Localisation;
       
        
    }

    public void setImg(ImageView value) {
        im = value;
    }

    public ImageView getImg() {
        return im;
    }
    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(String Localisation) {
        this.Localisation = Localisation;
    }

    public Produit(String Nom, String Image, String Prix, String Description) {
        this.Nom = Nom;
        this.Image = Image;
        this.Prix = Prix;
        this.Description = Description;
    }

    public Produit(String Nom, String Description ,String Prix) {
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

    public String getPrix() {
        return Prix;
    }

    public void setPrix(String Prix) {
        this.Prix = Prix;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Produit(String Nom,String Description,String Prix,String Localisation,String Image) {
        this.Nom = Nom;
        this.Image = Image;
        this.Prix = Prix;
        this.Description = Description;
        this.Localisation = Localisation;
    }

    

   
}
