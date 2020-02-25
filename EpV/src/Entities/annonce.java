package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Saif
 */
public class annonce {
    int id ; 
    String type ; 
    String commentaire ; 
    int idC ; 

    public annonce(int id, String type, String commentaire, int idC) {
        this.id = id;
        this.type = type;
        this.commentaire = commentaire;
        this.idC = idC;
    }

    public annonce(String type, String commentaire) {
        this.type = type;
        this.commentaire = commentaire;
    }

    public annonce() {
    }
    

    public annonce(String type, String commentaire, int idC) {
        this.type = type;
        this.commentaire = commentaire;
        this.idC = idC;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }
    
    
}
