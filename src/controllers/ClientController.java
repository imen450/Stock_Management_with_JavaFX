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
import Models.Client;


public class ClientController implements Initializable {
@FXML
  private Button RBtn;
 @FXML
  private Button ABtn;
 @FXML
 private Button SupprimBtn;
 @FXML
 private Button modBtn;
 @FXML
 private TableView<Models.Client> Clientstable;
 @FXML
 private TableColumn<Models.Client, Integer> id_client;
 @FXML
 private TableColumn<Models.Client, String> nom_prenom;
 @FXML
 private TableColumn<Models.Client, String> email;
 @FXML
 private TableColumn<Models.Client, Integer> tel;
 @FXML
 private TableColumn<Models.Client, String> adress;
 @FXML
 private TableColumn<Models.Client, String> ville;
  
 
 ObservableList<Models.Client> oblistclient= FXCollections.observableArrayList();
 @Override
  public void initialize(URL url, ResourceBundle rb) {
        try {
             
            
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM Client");
            
            
            while(rs.next())
            {
                oblistclient.add(new Client(rs.getInt("id_client"),rs.getString("email"), rs.getString("nom_prenom"), rs.getInt("tel"), rs.getString("adress"), rs.getString("ville")));
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        id_client.setCellValueFactory(cellData -> cellData.getValue().id_clientProperty().asObject());
        tel.setCellValueFactory(cellData -> cellData.getValue().telProperty().asObject());
        email.setCellValueFactory(cellData -> cellData.getValue().emailProperty());  
        nom_prenom.setCellValueFactory(cellData -> cellData.getValue().nom_prenomProperty());    
        adress.setCellValueFactory(cellData -> cellData.getValue().adressProperty());
        ville.setCellValueFactory(cellData -> cellData.getValue().villeProperty()); 
           
          
            Clientstable.setItems(oblistclient);
    } 
    @FXML
     private void OuvrirAjoutClient(ActionEvent e) throws IOException
    {
        Stage stage = new Stage();
        ABtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/Views/ajoutclient.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
}
      @FXML
    private void OuvrirModifClient(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        Stage oitems = new Stage();
        modBtn.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/Views/majclient.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
       
}
            
   
            
      @FXML
    private void Supprimer(ActionEvent e) throws IOException, ClassNotFoundException
    {
        PreparedStatement pst;

                int x = Clientstable.getSelectionModel().getSelectedItem().getId_client();
                Clientstable.getItems().removeAll(Clientstable.getSelectionModel().getSelectedItem());
                String sql="DELETE FROM Client WHERE id ='"+x+"'";
                     
                     
    
     try {
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            pst = connect.prepareStatement(sql);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Client supprimé  !");
                alert.showAndWait();
            System.out.println("Client supprimé !");
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