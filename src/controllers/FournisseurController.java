package controllers;

import java.io.IOException;


import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Models.Fournisseur;


public class FournisseurController implements Initializable {
@FXML
  private Button RBtn;
 @FXML
  private Button ABtn;
 @FXML
 private Button SupprimBtn;
 @FXML
 private Button modBtn;
 @FXML
 private TableView<Models.Fournisseur> Fournisseurstable;
 @FXML
 private TableColumn<Models.Fournisseur, Integer> id_fourni;
 @FXML
 private TableColumn<Models.Fournisseur, Integer> telf;
 @FXML
 private TableColumn<Models.Fournisseur, String> emailf;
 @FXML
 private TableColumn<Models.Fournisseur, String> nom_prenomf;
 @FXML
 private TableColumn<Models.Fournisseur, String> adressf;
 @FXML
 private TableColumn<Models.Fournisseur, String> villef;
  
 
 ObservableList<Models.Fournisseur> oblistFournisseur= FXCollections.observableArrayList();
 @Override
  public void initialize(URL url, ResourceBundle rb) {
        try {
             
            
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            ResultSet rs = connect.createStatement().executeQuery
            ("SELECT * FROM Fournisseur");
            
            while(rs.next())
            {
                oblistFournisseur.add(new Fournisseur(rs.getInt("id_fourni"), rs.getInt("telf"),rs.getString("emailf"), rs.getString("nom_prenomf"), rs.getString("adressf"), rs.getString("villef")));
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        id_fourni.setCellValueFactory(cellData -> cellData.getValue().id_fourniProperty().asObject());
        telf.setCellValueFactory(cellData -> cellData.getValue().telfProperty().asObject());
        emailf.setCellValueFactory(cellData -> cellData.getValue().emailfProperty());  
        nom_prenomf.setCellValueFactory(cellData -> cellData.getValue().nom_prenomfProperty());    
        adressf.setCellValueFactory(cellData -> cellData.getValue().adressfProperty());
        villef.setCellValueFactory(cellData -> cellData.getValue().villefProperty());    
            
           
          
            Fournisseurstable.setItems(oblistFournisseur);
    } 
    @FXML
     private void OuvrirAjoutFourni(ActionEvent e) throws IOException
    {
        Stage stage = new Stage();
        ABtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/Views/ajoutfourni.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
}
      @FXML
    private void OuvrirUpdFour(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        Stage oitems = new Stage();
        modBtn.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/Views/majfourni.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
       
}
            
      @FXML
    private void Supprimer(ActionEvent e) throws IOException, ClassNotFoundException
    {
        PreparedStatement pst;

                int x = Fournisseurstable.getSelectionModel().getSelectedItem().getId_fourni();
                Fournisseurstable.getItems().removeAll(Fournisseurstable.getSelectionModel().getSelectedItem());
                String sql="DELETE FROM Fournisseur WHERE id_fourni ='"+x+"'";
                     
                     
    
     try {
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            pst = connect.prepareStatement(sql);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Oop! Fournisseur supprimé  !");
                alert.showAndWait();
            System.out.println("Oop! Fournisseur supprimé !");
        } catch (ClassNotFoundException | SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Erreur");
                alert.showAndWait();
            System.out.println(ex.getMessage());
        }
}
   
  @FXML
private void Retourner(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        RBtn.getScene().getWindow().hide();
        Parent root3;
        root3 = FXMLLoader.load(getClass().getResource("/Views/accueil.fxml"));
        Scene scene = new Scene(root3);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}  
}
