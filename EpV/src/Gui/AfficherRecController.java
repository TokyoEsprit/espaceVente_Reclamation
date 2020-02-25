/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Produit;
import Entities.client;
import Entities.recCommande;
import Services.Service;
import Services.serviceprod;
import Services.servicereccom;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NAFA
 */
public class AfficherRecController implements Initializable {

    @FXML
    private AnchorPane chercher;
    @FXML
    private TableView<recCommande> table;
    @FXML
    private TableColumn<recCommande, String> nom;
    @FXML
    private TableColumn<recCommande,String > type;
    @FXML
    private TableColumn<recCommande, String> commentaire;
    @FXML
    private TableColumn<recCommande, String> client;
    @FXML
    private Button supp;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // récuperer les données a partir de  la base 
          ObservableList<recCommande> listu  = FXCollections.observableArrayList();
                   servicereccom sv = new servicereccom();
             Service s = new Service();
                   for(recCommande bb: sv.getListreccmd()) {
                   
                       listu.add(bb);
                   }
         //mettre les données dans la table view:    
         nom.setCellValueFactory(new PropertyValueFactory<>("etat"));
         type.setCellValueFactory(new PropertyValueFactory<>("type"));
         commentaire.setCellValueFactory(new PropertyValueFactory<>("contenu"));
         client.setCellValueFactory(new PropertyValueFactory<>("Email"));
       
       
        //load dummy data
        table.setItems(listu);
    }    

    @FXML
    private void supprimer(ActionEvent event) {
        servicereccom sv = new servicereccom () ;
    
         ObservableList<recCommande> SelectedRows, allpeople;
     
     allpeople = table.getItems();
     // il donne les ligne qui vous avez déja séléctionner
     SelectedRows =table.getSelectionModel().getSelectedItems();
     
     for(recCommande gg:SelectedRows){
       allpeople.remove(gg);
       sv.supprimerparID(gg.getId());
   
    }

    }

    @FXML
    private void Retour(ActionEvent event) {
        
          try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherProduitAdmin.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
}