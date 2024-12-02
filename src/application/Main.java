package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.Data;

public class Main extends Application {
    private static Stage primaryStageObj;

    @Override
    public void start(Stage primaryStage) {
    	
    	// Initialize data
        Data.getPatients();
        Data.getDoctors();
        
        try {
            primaryStageObj = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("LoginDoctor.fxml"));
            primaryStage.setTitle("HCP_Review_and_Booking_System");
            Scene scene = new Scene(root, 520, 400);
            scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(Exception e) {
            System.out.println("Error loading application: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void changeScene(String fxml) {
        try {
            Parent pane = FXMLLoader.load(Main.class.getResource(fxml));
            primaryStageObj.getScene().setRoot(pane);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error loading: " + fxml);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}