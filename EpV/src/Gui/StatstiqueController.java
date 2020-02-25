/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Services.serviceprod;
import Vente.Conct;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NAFA
 */
public class StatstiqueController implements Initializable {

     @FXML
    private BarChart<String, Integer> stat;

    Connection c= Conct.getInstance().getCnx();
    private serviceprod serv = new serviceprod();
    @FXML
    private Button Retour;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      

  
      String req =" SELECT COUNT(`idVelo`), `Date` FROM produit  GROUP BY `Date`";
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        try {
            Statement st =c.createStatement();
           ResultSet rs=st.executeQuery(req);
           int colonne1;
           String colonne2;
            while (rs.next()){
                colonne1=rs.getInt(1);
                colonne2=rs.getString(2);
                series.getData().add(new XYChart.Data<>(colonne2, colonne1));
            }
            stat.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(StatstiqueController.class.getName()).log(Level.SEVERE, null, ex);
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