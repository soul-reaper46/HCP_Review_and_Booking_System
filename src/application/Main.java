package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Data;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
    	// Initialize data
        Data.getPatients();
        Data.getDoctors();
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/DoctorDashboard.fxml"));
            Scene scene = new Scene(root, 1800, 800);
            scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Healthcare Booking System");
            primaryStage.setMaximized(true);  // Maximize the window by default
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
