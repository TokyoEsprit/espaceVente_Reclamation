/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Produit;
import Entities.Reclamation;
import Entities.recCommande;
import Entities.recEvent;
import Services.mailing;
import Services.servicerec;
import Services.servicereccom;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class AjoutReclamationController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private ChoiceBox<String> choix;
    @FXML
    private TextField produit;
    @FXML
    private TextField comm;
    @FXML
    private Button Annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    choix.getItems().add("Continue Indiserable");
        choix.getItems().add("livraison retard");
    choix.getItems().add("mal organisation");

    }    
 public void setProduit(String resNom) {
        this.produit.setText(resNom);
    }
    @FXML
    private void ajouter(ActionEvent event) {
        servicereccom sr = new servicereccom();
        recCommande r = new recCommande(choix.getValue(),comm.getText(),produit.getText());
        sr.ajouterRec(3, r);
        ((Node)(event.getSource())).getScene().getWindow().hide();
   
    try {
        
            mailing.sendMail("khnawel97@gmail.com","Bonjour, \n Votre reclamation de données :"+choix.getValue()+" "+comm.getText()+" "+produit.getText()+ " est en cours de traitement nous vous répondrons le plutot possible  \n Cordialement.");
        } catch (Exception ex) {
            Logger.getLogger(AjoutReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @FXML
    private void Annuler(ActionEvent event) {
                ((Node)(event.getSource())).getScene().getWindow().hide();

    }
    
}
