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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Oumaima.Tbibi
 */
public class AddProduitController implements Initializable {
    @FXML
    private TextField tfNom;
       String imgUrl  ="";
       
       private FileChooser uploadPic;
    private File picPath;
    @FXML
        private TextField Prix;
    @FXML
    private TextField Description;
    @FXML
    private TextField local;
    private TextField img;
    @FXML
    private Button ajouter;
    @FXML
    private Button addImage;
    @FXML
    private ImageView imageToPost;
    @FXML
    private Button Retour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void ajouter(ActionEvent event) throws IOException,SQLException {
        try {
        String nomP = tfNom.getText();
        String Description1 = Description.getText();
        String Prix1= Prix.getText() ;
        String local1= local.getText() ;
        if (imgUrl.equals(""))  { imgUrl =  "file:/C:/Users/NAFA/Desktop/Nawel%20pi/default.jpg"; }
        String img1= imgUrl;
        int test = 1;
       for (int i=0;i<Prix1.length();i++) {
           String s = Prix1.charAt(i)+"";
      
 if (Pattern.matches("[a-zA-Z]+", s )) {
    test = 0;
           Alert alert = new Alert(AlertType.INFORMATION);
alert.setHeaderText("Attention");
alert.setContentText("Verifier le prix");

alert.showAndWait();
}
  }       
    
        if (nomP.trim().length() < 1 ||Description1.trim().length() < 1 ||Prix1.trim().length() < 1 ||local1.trim().length() < 1  ) {
            Alert alert = new Alert(AlertType.INFORMATION);
alert.setHeaderText("Attention");
alert.setContentText("Verifier les champs");

alert.showAndWait();
        }
        else {
            if (test == 1) {
        serviceprod sp = new serviceprod();
      
        Produit p = new Produit(nomP,img1,Prix1,Description1,"0",local1);
        System.out.println(p.getNom());
        sp.ajouterProd(p,3);
        try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherProduit.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
        }
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
                
                BufferedImage buffImage = ImageIO.read(picPath);
                Image up = SwingFXUtils.toFXImage(buffImage, null);
                imageToPost.setImage(up);
            } catch(IOException ex){
                System.err.println(ex.getMessage());
            }
        
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
         javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("EspaceParticulier.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }

}

