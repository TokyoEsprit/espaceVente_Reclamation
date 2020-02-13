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
public class Avis {
    int id ;
    String Type ; 
    int idC ; 
    String Evaluation ; 

    public Avis() {
    }

    public Avis(int id, String Type, int idC, String Evaluation) {
        this.id = id;
        this.Type = Type;
        this.idC = idC;
        this.Evaluation = Evaluation;
    }

    public Avis(String Type, String Evaluation) {
        this.Type = Type;
        this.Evaluation = Evaluation;
    }

    public Avis(String Type, int idC, String Evaluation) {
        this.Type = Type;
        this.idC = idC;
        this.Evaluation = Evaluation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getEvaluation() {
        return Evaluation;
    }

    public void setEvaluation(String Evaluation) {
        this.Evaluation = Evaluation;
    }
    
    
}
