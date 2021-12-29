package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UpdateClient implements Initializable {

  @FXML
 private Button RBtn;
@FXML
private Button modBtn;
@FXML
private TextField txt1;
@FXML
private TextField txt11;
@FXML
private TextField txt2;
@FXML
private TextField txt3;
@FXML
private TextField txt4;
@FXML
private TextField txt5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
     @FXML
    private void update(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        
           Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
          
    
     try {
          String sql2="update Client set nom_prenom='"+txt1.getText()+"',tel='"+txt2.getText()+"', email='"+txt3.getText()+"',adress='"+txt4.getText()+"',ville='"+txt5.getText()+"' where id_client='"+txt11.getText()+"'";
         PreparedStatement pst;
            pst = connect.prepareStatement(sql2);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Inforamtion mise a jour avec succés !");
                alert.showAndWait();
            System.out.println("Inforamtion mise a jour avec succés !");
        } catch (NumberFormatException | SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Erreur");
                alert.showAndWait();
            System.out.println(ex);
        }
} 
      @FXML
private void Retourner(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        RBtn.getScene().getWindow().hide();
        Parent root3;
        root3 = FXMLLoader.load(getClass().getResource("/Views/client.fxml"));
        Scene scene = new Scene(root3);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
} 
}