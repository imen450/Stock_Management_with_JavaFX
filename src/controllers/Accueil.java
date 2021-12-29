package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Accueil implements Initializable {

 @FXML
    private Button StockBtn;
    @FXML
    private Button AchatBtn;
    @FXML
    private Button ClientBtn;
    @FXML
    private Button FourBtn;
    @FXML
    private Button VenteBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
   
    
    
    @FXML
    private void OuvrirStock(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        StockBtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/Views/stock.fxml"));
        Scene scene = new Scene(root1);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}
      @FXML
    private void OuvrirAchat(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        AchatBtn.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/Views/achat.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}
      @FXML
    private void OuvrirClient(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        ClientBtn.getScene().getWindow().hide();
        Parent root3;
        root3 = FXMLLoader.load(getClass().getResource("/Views/client.fxml"));
        Scene scene = new Scene(root3);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}
      @FXML
      private void OuvrirFournisseur(ActionEvent e) throws IOException
      {
          Stage oitems = new Stage();
          FourBtn.getScene().getWindow().hide();
          Parent root4;
          root4 = FXMLLoader.load(getClass().getResource("/Views/fournisseur.fxml"));
          Scene scene = new Scene(root4);
          oitems.setScene(scene);
          oitems.show();
          oitems.setResizable(false);
  }
      @FXML
      private void OuvrirVente(ActionEvent e) throws IOException
      {
          Stage oitems = new Stage();
          VenteBtn.getScene().getWindow().hide();
          Parent root5;
          root5 = FXMLLoader.load(getClass().getResource("/Views/vente.fxml"));
          Scene scene = new Scene(root5);
          oitems.setScene(scene);
          oitems.show();
          oitems.setResizable(false);
  }
}