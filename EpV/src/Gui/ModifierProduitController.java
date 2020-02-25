/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Produit;
import Services.serviceprod;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author NAFA
 */
public class ModifierProduitController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField Description;
    @FXML
    private TextField Prix;
    @FXML
   
    private TextField local;
    @FXML
    private Button addImage;
    @FXML
    private ImageView imageToPost;

      String imgUrl;
       
       private FileChooser uploadPic;
    private File picPath;
    @FXML
    private Button Enregistrer;
    @FXML
    private TextField id;
    @FXML
    private TextField img;
    @FXML
    private Button Annuler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  public void setI(String tfNom) {
        this.img.setText(tfNom);
    }  
 public void setNom(String tfNom) {
        this.tfNom.setText(tfNom);
    }
 public void setId(String id) {
        this.id.setText(id);
    }
    public void setDescription(String Description) {
        this.Description.setText(Description);
    }
    
      public void setLocal(String local) {
        this.local.setText(local);
    }
     public void setPrix(String Prix) {
        this.Prix.setText(Prix);
    }
     

    public void setImage(Produit p) {
             ImageView im = new ImageView() ;
                Image ii = new Image(p.getImage());
                imageToPost.setImage(ii);
    }
    @FXML
    private void addImage(ActionEvent event) {
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            uploadPic = new FileChooser();
            uploadPic.setTitle("Select the image you want to add");
            picPath = uploadPic.showOpenDialog(stage);
            System.out.println(picPath.toString());
            
            try {
                imgUrl = picPath.toURI().toURL().toExternalForm();
                img.setText(imgUrl);
                BufferedImage buffImage = ImageIO.read(picPath);
                Image up = SwingFXUtils.toFXImage(buffImage, null);
                imageToPost.setImage(up);
            } catch(IOException ex){
                System.err.println(ex.getMessage());
            }

    }

    @FXML
    private void Enregistrer(ActionEvent event) {
        serviceprod sv = new serviceprod() ;
    int x =  (Integer)   Integer.parseInt(id.getText()) ;
    Produit p = new Produit();
    p.setId(x);
    p.setNom(tfNom.getText());
    p.setPrix(Prix.getText());
    p.setDescription(Description.getText());
    double px =(Double) Double.parseDouble(Prix.getText());
    sv.modifierProd(x,tfNom.getText(),px,Description.getText(),local.getText(),img.getText());
      try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("EspaceParticulier.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void Annuler(ActionEvent event) {
          try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("EspaceParticulier.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
