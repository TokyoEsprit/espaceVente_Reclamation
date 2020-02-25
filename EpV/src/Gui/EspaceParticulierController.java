/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Produit;
import Services.serviceprod;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EspaceParticulierController implements Initializable {

    private TextField Description;
private TextField Prix ; 
    @FXML
    private TableColumn<Produit, String> nom;
    @FXML
    private TableColumn<Produit, String> descrip;
    @FXML
    private TableColumn<Produit,String > prix;
    @FXML
    private TableColumn<Produit, String> etat;
    @FXML
    private TableColumn<Produit, ImageView> img;
    @FXML
    private TableColumn<Produit, String> local;
    @FXML
        private TableColumn<Produit, Integer> id;
    @FXML
    private TableView<Produit> table;
    serviceprod sv =new serviceprod();
    @FXML
    private Button supp;
    @FXML
    private AnchorPane chercher;
    @FXML
    private Button Chercher;
    @FXML
    private TextField ch;
    @FXML
    private Button Ajouter;
    @FXML
    private TextField idClient;
    @FXML
    private Button Modifier;
    @FXML
    private Button Retour;
     public void setResNom(TextField resNom) {
        this.idClient.setText(resNom.getText());
    }
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
         // récuperer les données a partir de  la base 
          ObservableList<Produit> listu  = FXCollections.observableArrayList();
     try {
    // int i = (int) Integer.parseInt(idClient.getText());
     int i = 3;    
         for(Produit bb: sv.getListProdC(i)) {
               Image x = new Image(bb.getImage());
             ImageView im = new ImageView() ;
               im.setFitHeight(100);
im.setFitWidth(100);
                im.setImage(x);
               bb.setImg(im);
             listu.add(bb);
         }
     
     } catch (SQLException ex) {
         Logger.getLogger(serviceprod.class.getName()).log(Level.SEVERE, null, ex);
     }

         //mettre les données dans la table view:    
                  id.setCellValueFactory(new PropertyValueFactory<>("id"));

         nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
         descrip.setCellValueFactory(new PropertyValueFactory<>("Description"));
         prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
         etat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
         img.setCellValueFactory(new PropertyValueFactory<>("img"));
         local.setCellValueFactory(new PropertyValueFactory<>("Localisation"));
       
        //load dummy data
        table.setItems(listu);
        
        
    }    

    @FXML
    private void supprimer(ActionEvent event) {
        
        ObservableList<Produit> SelectedRows, allpeople;
     
     allpeople = table.getItems();
     // il donne les ligne qui vous avez déja séléctionner
     SelectedRows =table.getSelectionModel().getSelectedItems();
     
     for(Produit gg:SelectedRows){
       allpeople.remove(gg);
       sv.supprimerparID(gg.getId());
    }
     
    }


    @FXML
    private void Ajouter(ActionEvent event) {
         try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AddProduit.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Chercher(ActionEvent event) {
          String text = ch.getText();
              ObservableList<Produit> listu  = FXCollections.observableArrayList();
     try {
        
         
         for(Produit bb: sv.RechercherProduit(text))
             listu.add(bb);
            table.setItems(listu); 
     
     } catch (SQLException ex) {
         Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
     }   
    }


    @FXML
    private void Modifier(ActionEvent event) throws IOException  {
        
         Produit p = table.getSelectionModel().getSelectedItem();
     FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierProduit.fxml"));
            Parent root = loader.load();
           ModifierProduitController scene2Controller = loader.getController();
               
            //Get controller of scene2
            //Pass whatever data you want. You can have multiple method calls here
                        scene2Controller.setId(p.getId()+"");

              scene2Controller.setDescription(p.getDescription());
               scene2Controller.setPrix(p.getPrix()); 
                              scene2Controller.setImage(p); 
scene2Controller.setLocal(p.getLocalisation()); 
scene2Controller.setNom(p.getNom());
        scene2Controller.setI(p.getImage());

                Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Hello World");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
}

    @FXML
    private void Retour(ActionEvent event) {
        
          try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherProduit.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
      

    }
