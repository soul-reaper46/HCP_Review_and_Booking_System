package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert.AlertType;
import model.Data;
import model.Feedback;

public class DoctorRatingController {

    @FXML private ComboBox<String> doctorComboBox;
    @FXML private Slider analysisRatingSlider;
    @FXML private Slider treatmentRatingSlider;
    @FXML private Slider behaviourRatingSlider;
    @FXML private Slider costRatingSlider;
    @FXML private Button submitRatingButton;
    @FXML private Button backButton;

    @FXML
    private void initialize() {
        // Populate doctor names into the combo box
        ObservableList<String> doctorNames = FXCollections.observableArrayList();
        Data.getDoctors().forEach(doctor -> doctorNames.add(doctor.getName()));
        doctorComboBox.setItems(doctorNames);
    }

    @FXML
    private void handleSubmitButton() {
        String selectedDoctor = doctorComboBox.getValue();

        if (selectedDoctor == null) {
            showAlert("Error", "Please select a doctor.", AlertType.ERROR);
            return;
        }

        // Collect ratings from sliders
        int analysisRating = (int) analysisRatingSlider.getValue();
        int treatmentRating = (int) treatmentRatingSlider.getValue();
        int behaviourRating = (int) behaviourRatingSlider.getValue();
        int costRating = (int) costRatingSlider.getValue();

        // Find the doctor's ID based on their name
        int doctorId = Data.getDoctors().stream()
                .filter(doctor -> doctor.getName().equals(selectedDoctor))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"))
                .getDoctorId();

        // Create a Feedback object
        Feedback feedback = new Feedback(
                doctorId,
                analysisRating,
                treatmentRating,
                behaviourRating,
                costRating,
                ""); 

        // Add the feedback to the feedbackList in Data class
        Data.addFeedback(feedback);

        // Show success alert
        showAlert("Success", "Rating submitted successfully!", AlertType.INFORMATION);

        // Reset the fields
        doctorComboBox.getSelectionModel().clearSelection();
        analysisRatingSlider.setValue(3);
        treatmentRatingSlider.setValue(3);
        behaviourRatingSlider.setValue(3);
        costRatingSlider.setValue(3);
    }

    @FXML
    private void handleBackButton() {
        try {
            // Navigate back to the LoginDoctor screen
            Main.changeScene("/view/LoginDoctor.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
