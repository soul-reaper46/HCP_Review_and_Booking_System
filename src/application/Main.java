package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
    private static Stage primaryStageObj;
    private static Database database;

    @Override
    public void start(Stage primaryStage) {
        try {
            database = Database.getInstance();
            primaryStageObj = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("LoginDoctor.fxml"));
            primaryStage.setTitle("HCP_Review_and_Booking_System");
            Scene scene = new Scene(root, 520, 400);
            scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(Exception e) {
            showError("Error loading application", e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void changeScene(String fxml) {
        try {
            Parent pane = FXMLLoader.load(Main.class.getResource(fxml));
            primaryStageObj.getScene().setRoot(pane);
        } catch(Exception e) {
            showError("Navigation Error", "Error loading: " + fxml);
            e.printStackTrace();
        }
    }

    private static void showError(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}