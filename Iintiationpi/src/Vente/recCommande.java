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
public class recCommande extends Reclamation{

    String Type ;
           

    public recCommande() {
    }

    public recCommande(String Type, String contenu, String Etat) {
        super(contenu, Etat);
        this.Type = Type;
    }
    

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    

    public recCommande(String Type) {
        this.Type = Type;
    }

    public recCommande(int id, int idCl, String contenu, String Etat) {
        super(id, idCl, contenu, Etat);
    }

    public recCommande(String etat, int id, int idCl, String contenu, String Etat) {
        super(id, idCl, contenu, Etat);
        this.Type = Type;
    }

  
    
}
