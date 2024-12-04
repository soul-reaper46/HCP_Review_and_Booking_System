package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Rectangle2D;
import model.Data;

public class Main extends Application {
    private static Stage primaryStageObj;
    private static Database database;

    @Override
    public void start(Stage primaryStage) {
        // Initialize data
        Data.getPatients();
        Data.getDoctors();
        Data.getAppointments();

        try {
            database = Database.getInstance();
            primaryStageObj = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("/view/LoginDoctor.fxml"));
            primaryStage.setTitle("HCP Review and Booking System");

            // Get screen dimensions for full-screen mode
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
            scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());

            // Allow resize and display maximize/minimize/close buttons
            primaryStage.setResizable(true);
            primaryStage.setMaximized(true);
            // Set the scene and show the stage
            primaryStage.setScene(scene);
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
                Scene dashboardScene = new Scene(pane, Screen.getPrimary().getVisualBounds().getWidth(),
                        Screen.getPrimary().getVisualBounds().getHeight());
                dashboardScene.getStylesheets().add(Main.class.getResource("/css/Style.css").toExternalForm());
                primaryStageObj.setScene(dashboardScene);
            } else {
                primaryStageObj.setResizable(true);
                primaryStageObj.setMaximized(true);
                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                Scene loginScene = new Scene(pane, screenBounds.getWidth(), screenBounds.getHeight());
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
