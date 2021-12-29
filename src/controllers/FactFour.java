package controllers;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Models.FactureFourni;

public class FactFour implements Initializable{
    @FXML
    private Button RBtn;
    @FXML
    private TableView<Models.FactureFourni> tableFactFr;
    @FXML
    private TableColumn<Models.FactureFourni, Integer> N_fact;
    @FXML
    private TableColumn<Models.FactureFourni, Float> Montant;
    @FXML
    private TableColumn<Models.FactureFourni, Float> TVA;
    @FXML
    private TableColumn<Models.FactureFourni, Integer> id_fourni;
    
    
    ObservableList<Models.FactureFourni> oblistFact = FXCollections.observableArrayList();
    @FXML
    private Button imp;
    @FXML
    private TextField montant;
    @FXML
    private TextField id;
    @FXML
    private TextField num;
    @FXML
    private TextField tva;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,""); 
            ResultSet rs = connect.createStatement().executeQuery
            ("SELECT * FROM FactureFourni");
   
            
            while(rs.next())
            {
                oblistFact.add(new FactureFourni(rs.getInt("N_fact"), (int)rs.getFloat("Montant"), rs.getFloat("TVA"), rs.getInt("id_fourni")));
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FactClt.class.getName()).log(Level.SEVERE, null, ex);}
		
        
    N_fact.setCellValueFactory(cellData -> cellData.getValue().N_factProperty().asObject());
    Montant.setCellValueFactory(cellData -> cellData.getValue().MontantProperty().asObject());
    TVA.setCellValueFactory(cellData -> cellData.getValue().TVAProperty().asObject());
    id_fourni.setCellValueFactory(cellData -> cellData.getValue().id_fourniProperty().asObject());
  
    tableFactFr.setItems(oblistFact);
            
    }
  
    
    @FXML
    public void Retourner(ActionEvent e) throws IOException
    {
        Stage hm = new Stage();
        RBtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/Views/achat.fxml"));
        Scene scene = new Scene(root1);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }
    @FXML
    private void supprimer(ActionEvent e) throws IOException
    {
    	try {
    		PreparedStatement pst;

                int id = tableFactFr.getSelectionModel().getSelectedItem().getId_fourni();
                tableFactFr.getItems().removeAll(tableFactFr.getSelectionModel().getSelectedItem());
                String sql="DELETE FROM FactureFourni WHERE id_fourni ='"+id+"'";
                     
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText(" Une Facture a été supprimé !");
                alert.showAndWait();
            System.out.println("Facture d'Achat supprimée avec succés!");   
    
     
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionDeStock", "root" ,"");
            pst = connect.prepareStatement(sql);   
            pst.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Erreur !");
                alert.showAndWait();
            System.out.println(ex.getMessage());
        }}
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
           String sql="INSERT INTO FactureFourni (N_fact,Montant,TVA,id_fourni) VALUES ('"+Integer.parseInt(num.getText())+"','"+Float.parseFloat(montant.getText())+"','"+Float.parseFloat(tva.getText())+"','"+Integer.parseInt(id.getText())+"')";
                  
                
           pst = connect.prepareStatement(sql);
           pst.executeUpdate(sql);
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("--Facture ajoutée avec succées !--- ");
           alert.showAndWait();
           System.out.println("------ Facture ajoutée avec succées !  -----");

}catch(Exception ex){
   System.out.println(ex);
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText(" Une erreur s'est produit !!!");
           alert.showAndWait();
           System.out.println(ex);
}

}
    
    
    @FXML
    private void imprimer(ActionEvent event) {
        int imN_fact = tableFactFr.getSelectionModel().getSelectedItem().getN_fact();
        float imMontant = tableFactFr.getSelectionModel().getSelectedItem().getMontant();
        float imTVA = tableFactFr.getSelectionModel().getSelectedItem().getTVA();
        int imid_four = tableFactFr.getSelectionModel().getSelectedItem().getId_fourni();


        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream("Facture N."+imN_fact+".pdf"));
            document.open();

            Font f=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,24));
            f.setColor(64,64,64);
            
            Font f2=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD));
            f2.setColor(255,229,204);
            Paragraph p1 = new Paragraph(" Facture N° :  "+ imN_fact ,f);
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph p0 = new Paragraph("     ");
                 
            Paragraph p2 = new Paragraph("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--__-_-_--_-_-_-");
            Paragraph p4 = new Paragraph("      Montant :   " +"                       "+imMontant);
            Paragraph p3 = new Paragraph("      TVA :  "+"                              "+imTVA);
            Paragraph p5 = new Paragraph("      Identifiant du Client :  "+"          "+imid_four);
          
            Paragraph p9 = new Paragraph("~~ NOUS VOUS REMERCIONS DE NOUS AVOIR CHOISIS ~~ ");
            p9.setAlignment(Paragraph.ALIGN_CENTER);
            
	    
            document.add(p0);
            document.add(p1);
            document.add(p0);
            document.add(p2);
            document.add(p0);
            document.add(p0);
            document.add(p4);
            document.add(p0);
            document.add(p5);
            document.add(p0);
            document.add(p3);
            document.add(p0);
            document.add(p2);
            document.add(p0);
            document.add(p0);
            document.add(p9);
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Facturation");
                alert.setContentText("Facture ( "+ imN_fact + " ) du fournisseur  ( " + imid_four + " )   généré avec succés !");
                alert.showAndWait();
        }
        catch(DocumentException | FileNotFoundException e){
            System.out.println(e);
        }
        document.close();
    }
}
