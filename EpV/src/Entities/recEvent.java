/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Reclamation;

/**
 *
 * @author Saif
 */
public class recEvent extends Reclamation { 
    
    String type ; 

    public recEvent(String type, int id,int idCl ,String contenu ,String Etat ) {
       super(id,idCl,contenu,Etat);
        this.type = type;
    }
    
    

    public recEvent(String Type ,String contenu, String Etat) {
        super(contenu, Etat);
        this.type=Type ; 
    }
    
    
    public recEvent(String type, String contenu,String Etat ,int idCl ) {
       super(contenu,Etat,idCl);
        this.type = type;
    }

    public recEvent() {
    }

    public recEvent(String type) {
        this.type = type;
    }

    public recEvent(int id, int idCl, String contenu, String Etat) {
        super(id, idCl, contenu, Etat);
    }
    public int getId () {
    return super.id ; 
}
    public void setId(int id) {
        this.id=id ; 
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
   
    
}