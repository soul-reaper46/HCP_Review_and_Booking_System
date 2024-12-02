package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Data;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize data
        Data.getPatients();
        Data.getDoctors();

        try {
            database = Database.getInstance();
            primaryStageObj = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("/view/LoginDoctor.fxml"));
            primaryStage.setTitle("HCP_Review_and_Booking_System");
            Scene scene = new Scene(root, 520, 400);
            scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Healthcare Booking System");
            primaryStage.setMaximized(true);  // Maximize the window by default
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch (Exception e) {
            showError("Error loading application", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void changeScene(String fxml) {
        try {
            Parent pane = FXMLLoader.load(Main.class.getResource(fxml));

            if (fxml.contains("Dashboard")) {
                primaryStageObj.setResizable(true);
                primaryStageObj.setMaximized(true);
                Scene dashboardScene = new Scene(pane, 1800, 800);
                dashboardScene.getStylesheets().add(Main.class.getResource("StyleSheet.css").toExternalForm());
                primaryStageObj.setScene(dashboardScene);
            } else {
                primaryStageObj.setResizable(false);
                if (primaryStageObj.isMaximized()) {
                    primaryStageObj.setMaximized(false);
                }
                Scene loginScene = new Scene(pane, 520, 400);
                loginScene.getStylesheets().add(Main.class.getResource("StyleSheet.css").toExternalForm());
                primaryStageObj.setScene(loginScene);
            }
        } catch (Exception e) {
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
