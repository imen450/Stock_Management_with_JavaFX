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
import javafx.scene.control.TextField;
import Models.Achat;

public class 	AchatController implements Initializable {
@FXML
private TextField txt1;
@FXML
private TextField txt2;
@FXML
private TextField txt3;
@FXML
private TextField txt4;
@FXML
private TextField txt5;
@FXML
  private Button RBtn;
@FXML
private Button FacBtn;
 @FXML
  private Button ABtn;
 @FXML
 private Button SupprimBtn;
 @FXML
 private Button modBtn;
 @FXML
 private TableView<Models.Achat> Achattable;
 @FXML
 private TableColumn<Models.Achat,Integer> N_achat;
 @FXML
 private TableColumn<Models.Achat, Integer> id_fourn;
 @FXML
 private TableColumn<Models.Achat, Integer> id_prod;
 @FXML
 private TableColumn<Models.Achat, Integer> quantité;
 @FXML
 private TableColumn<Models.Achat, String> date;
 ObservableList<Models.Achat> oblistAchat= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             
            
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            ResultSet rs = connect.createStatement().executeQuery
            ("SELECT * FROM Achat");
            
            while(rs.next())
            {
            	oblistAchat.add(new Achat(rs.getInt("N_achat"),rs.getInt("id_fourn"), rs.getInt("id_prod"),rs.getInt("quantité"),rs.getString("date")));
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AchatController.class.getName()).log(Level.SEVERE, null, ex);}
         
         N_achat.setCellValueFactory(cellData -> cellData.getValue().N_achatProperty().asObject());
         id_fourn.setCellValueFactory(cellData -> cellData.getValue().id_fournProperty().asObject());
         id_prod.setCellValueFactory(cellData -> cellData.getValue().id_prodProperty().asObject());
         quantité.setCellValueFactory(cellData -> cellData.getValue().quantitéProperty().asObject());
         date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
         
 
            Achattable.setItems(oblistAchat);
    } 
    
    @FXML
    private void Ajouter(ActionEvent event) throws IOException , ClassNotFoundException , SQLException
    {
        try {
        String url="jdbc:mysql://localhost:3306/GestionDeStock";
            String username="root";
            String password=""; 
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection(url, username, password);
           PreparedStatement pst;            
         String sql="INSERT INTO Achat (N_achat,id_fourn,id_prod,quantité,date) VALUES ('"+Integer.parseInt(txt1.getText())+"','"+Integer.parseInt(txt2.getText())+"', '"+Integer.parseInt(txt3.getText())+"','"+Integer.parseInt(txt4.getText())+"','"+txt5.getText()+"')";
                
              
                pst = connect.prepareStatement(sql);
                pst.executeUpdate(sql);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("----Commande d'achat est bien enregistrée !--- ");
                alert.showAndWait();
                System.out.println("------ Commande d'achat enregistrée -----");
  
    }catch(Exception ex){
        System.out.println(ex);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(" Une erreur s'est produit !!!");
                alert.showAndWait();
                System.out.println(ex);
    }

}

      @FXML
    private void supprimer(ActionEvent e) throws IOException
    {
         PreparedStatement pst;

                String x = Achattable.getSelectionModel().getSelectedItem().getDate();
                Achattable.getItems().removeAll(Achattable.getSelectionModel().getSelectedItem());
                String sql="DELETE FROM Achat WHERE date ='"+x+"'";
                     
                     
    
     try {
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            pst = connect.prepareStatement(sql);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Commande d'achat supprimée avec succés!");
                alert.showAndWait();
            System.out.println("Commande d'achat supprimée avec succés!");
        } catch (ClassNotFoundException | SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Erreur !");
                alert.showAndWait();
            System.out.println(ex.getMessage());
        }
}   
      @FXML
      private void OuvrirUpdateAchat(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
      {
          Stage oitems = new Stage();
          modBtn.getScene().getWindow().hide();
          Parent root2;
          root2 = FXMLLoader.load(getClass().getResource("/Views/majachat.fxml"));
          Scene scene = new Scene(root2);
          oitems.setScene(scene);
          oitems.show();
          oitems.setResizable(false);
         
  }
      @FXML
      private void OuvrirFactureAchat(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
      {
          Stage oitems = new Stage();
          FacBtn.getScene().getWindow().hide();
          Parent root4;
          root4 = FXMLLoader.load(getClass().getResource("/Views/FactFr.fxml"));
          Scene scene = new Scene(root4);
          oitems.setScene(scene);
          oitems.show();
          oitems.setResizable(false);
         
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