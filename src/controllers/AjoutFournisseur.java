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


public class AjoutFournisseur implements Initializable {

   @FXML
 private Button RBtn;
@FXML
private Button ABtn;
@FXML
private TextField emailf;
@FXML
private TextField nom_prenomf;
@FXML
private TextField telf;
@FXML
private TextField adressf;
@FXML
private TextField villef;
@FXML
private TextField id_fourni;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
         String sql="INSERT INTO Fournisseur (id_fourni,telf,emailf,nom_prenomf,adressf,villef) VALUES ('"+Integer.parseInt(id_fourni.getText())+"','"+Integer.parseInt(telf.getText())+"','"+emailf.getText()+"', '"+nom_prenomf.getText()+"','"+adressf.getText()+"','"+villef.getText()+"')";
                
              
                pst = connect.prepareStatement(sql);
                pst.executeUpdate(sql);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(" --Fournisseur ajouté avec succés ! -- ");
                alert.showAndWait();
                System.out.println("---- Fournisseur ajouté ----");
       
        Stage stage = new Stage();
        ABtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/Views/ajoutfourni.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);



    }catch(IOException | ClassNotFoundException | NumberFormatException | SQLException ex){
        System.out.println(ex);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("une erreur s'est produit ! ");
                alert.showAndWait();
                System.out.println(ex);
    }

}
  @FXML
private void Retourner(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        RBtn.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/Views/fournisseur.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}
}