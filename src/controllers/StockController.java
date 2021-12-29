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
import Models.Stock;


public class StockController implements Initializable {
@FXML
  private Button RBtn;
 @FXML
  private Button ABtn;
 @FXML
 private Button SupprimBtn;
 @FXML
 private Button modBtn;
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
 private TableView<Models.Stock> Stocktable;
 @FXML
 private TableColumn<Models.Stock,Integer> id_prod;
 @FXML
 private TableColumn<Models.Stock, String> nom;
 @FXML
 private TableColumn<Models.Stock, String> categorie;
 @FXML
 private TableColumn<Models.Stock, Integer> qt_tot;
 @FXML
 private TableColumn<Models.Stock, Float> prix;
 ObservableList<Models.Stock> oblistStock= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             
            
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            ResultSet rs = connect.createStatement().executeQuery
            ("SELECT * FROM Stock");
            
            while(rs.next())
            {
            	oblistStock.add(new Stock(rs.getInt("id_prod"),rs.getString("nom"), rs.getString("categorie"),rs.getInt("qt_tot"),rs.getFloat("prix")));
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);}
         
         id_prod.setCellValueFactory(cellData -> cellData.getValue().id_prodProperty().asObject());
         nom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());  
         categorie.setCellValueFactory(cellData -> cellData.getValue().categorieProperty());
         qt_tot.setCellValueFactory(cellData -> cellData.getValue().qt_totProperty().asObject());
         prix.setCellValueFactory(cellData -> cellData.getValue().prixProperty().asObject());
 
            Stocktable.setItems(oblistStock);
            
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
           String sql="INSERT INTO Stock (id_prod,nom,categorie,qt_tot,prix) VALUES ('"+Integer.parseInt(txt1.getText())+"','"+txt2.getText()+"', '"+txt3.getText()+"','"+Integer.parseInt(txt4.getText())+"','"+Float.parseFloat(txt5.getText())+"')";
                  
                
                  pst = connect.prepareStatement(sql);
                  pst.executeUpdate(sql);
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setContentText("**** Produit ajouté avec succés !*****");
                  alert.showAndWait();
                  System.out.println("----- Produit ajouté ----- ");
  

      }catch(Exception ex){
          System.out.println(ex);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setContentText("une erreur s'est produit !");
                  alert.showAndWait();
                  System.out.println(ex);
      }

  }
    @FXML
    private void OuvrirUpdateStock(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        Stage oitems = new Stage();
        modBtn.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/Views/majstock.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
       
}

      @FXML
    private void supprimer(ActionEvent e) throws IOException
    {
         PreparedStatement pst;
                int id = Stocktable.getSelectionModel().getSelectedItem().getId_prod();
                Stocktable.getItems().removeAll(Stocktable.getSelectionModel().getSelectedItem());
                String sql=  "DELETE FROM Stock WHERE id_prod='"+id+"'";
                     
                     
    
     try {
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            pst = connect.prepareStatement(sql);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Produit supprimé !");
                alert.showAndWait();
            System.out.println("Produit supprimé !");
        } catch (ClassNotFoundException | SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Erreur !");
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