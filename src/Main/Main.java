package Main;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) 
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Views/login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Gestion De Stock");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(true);
        } catch (IOException e) { }
    }

    public static void main(String[] args) {
        launch();
       
    }
    }
    