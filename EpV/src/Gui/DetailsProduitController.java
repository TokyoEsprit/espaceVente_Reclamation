/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Produit;
import Entities.recCommande;
import Services.mailVendeur;
import Services.serviceprod;
import Services.servicereccom;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NAFA
 */
public class DetailsProduitController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private TextField nomP;
    @FXML
    private TextField Descrip;
    @FXML
    private TextField Prix;
    @FXML
    private Label pri;
    @FXML
    private Button Contacter;
    @FXML
    private AnchorPane table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }    
    public void setProduit(String nomP) {
        this.nomP.setText(nomP);
    }
    public void setDescription(String Descrip) {
        this.Descrip.setText(Descrip);
    }
     public void setPrix(String Prix) {
        this.Prix.setText(Prix);
    }
     

    public void setImage(Produit p) {
             ImageView im = new ImageView() ;
                Image ii = new Image(p.getImage());
                img.setImage(ii);
    }
  

    @FXML
    private void Contacter(ActionEvent event) {
        
         try {
            mailVendeur.sendMail("khnawel97@gmail.com","Bonjour, \n Votre reclamation est en cours de traitement nous vous répondrons le plutot possible  \n Cordialement.");
        } catch (Exception ex) {
            Logger.getLogger(DetailsProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
