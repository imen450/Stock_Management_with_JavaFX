package controllers;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class LoginController implements Initializable {

   @FXML
    private TextField nom;

    @FXML
    private PasswordField mdp;

    @FXML
    private Button loginBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
   
   @FXML
    public void login(ActionEvent e) throws IOException, ClassNotFoundException
    {    String sql = "SELECT * FROM utilisateur WHERE nom=? AND mdp=?";
        try { String url="jdbc:mysql://localhost:3306/GestionDeStock";
            String username="root";
            String password=""; 
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nom.getText());
            pst.setString(2, mdp.getText());
            
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            
            if (count==1)
            {
                System.out.println("Connexion Admin avec succés");
            
                
                Stage logp = new Stage();
                logp.setTitle("Accueil");
                loginBtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/accueil.fxml"));
                Scene scene = new Scene(rootA);
                logp.setScene(scene);
                logp.show();
                logp.setResizable(false);           
           }          
                    
           else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("SVP ! , Vérifier vos données !");
                alert.showAndWait();
           }
       }catch(Exception ee){
           System.out.println(ee);
       }
    }
}