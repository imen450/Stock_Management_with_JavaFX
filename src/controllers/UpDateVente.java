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

public class UpDateVente implements Initializable {
  @FXML
 private Button RBtn;

@FXML
private TextField txt1;
@FXML
private TextField txt11;
@FXML
private TextField txt2;
@FXML
private TextField txt3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
     @FXML
    private void Modifier(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        
           Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
           
                     
                     
    
     try {
          String sql2="update Vente set idc='"+Integer.parseInt(txt1.getText())+"', idp='"+Integer.parseInt(txt2.getText())+"',qt='"+Integer.parseInt(txt3.getText())+"' where N_vente='"+txt11.getText()+"'";
         PreparedStatement pst;
            pst = connect.prepareStatement(sql2);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText(" le mise a jour est bien fait  !");
                alert.showAndWait();
            System.out.println(" Commande de vente est bien modifiée ");
        } catch (NumberFormatException | SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Erreur !");
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
        root3 = FXMLLoader.load(getClass().getResource("/views/Vente.fxml"));
        Scene scene = new Scene(root3);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
} 
}