/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Saif
 */
public class Reclamation {
    int id ; 
    int idCl ; 
    String contenu ; 
    String Etat ; 
    String Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public Reclamation(int id, int idCl, String contenu, String Etat) {
        this.id = id;
        this.idCl = idCl;
        this.contenu = contenu;
        this.Etat = Etat;
    }
  public Reclamation( int idCl, String contenu, String Etat) {
 
        this.idCl = idCl;
        this.contenu = contenu;
        this.Etat = Etat;
    }
    public Reclamation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCl() {
        return idCl;
    }

    public void setIdCl(int idCl) {
        this.idCl = idCl;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public Reclamation(String contenu, String Etat, int idCl) {
        this.idCl = idCl;
        this.contenu = contenu;
        this.Etat = Etat;
    }

    public Reclamation(String contenu, String Etat) {
        this.contenu = contenu;
        this.Etat = Etat;
    }
    
    
}
