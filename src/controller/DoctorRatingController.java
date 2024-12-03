package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import application.Main;
import model.Data;
import model.Doctor;

public class DoctorRatingController {

    @FXML private ComboBox<String> doctorComboBox;
    @FXML private TextField ratingField;
    @FXML private TextArea feedbackField;
    @FXML private Button submitButton;
    @FXML private Button backButton;  // Back button to navigate back to the AppointmentBooking screen

    @FXML
    private void initialize() {
        // Populate doctors into the ComboBox
        ObservableList<String> doctorNames = FXCollections.observableArrayList();
        for (Doctor doctor : Data.getDoctors()) {
            if (doctor != null && doctor.getName() != null) {
                doctorNames.add(doctor.getName());
            }
        }
        doctorComboBox.setItems(doctorNames);
    }

    @FXML
    private void handleSubmitButton() {
        String selectedDoctor = doctorComboBox.getValue();
        String rating = ratingField.getText();
        String feedback = feedbackField.getText();

        if (selectedDoctor != null && !rating.isEmpty() && !feedback.isEmpty()) {
            System.out.println("Rating submitted:");
            System.out.println("Doctor: " + selectedDoctor);
            System.out.println("Rating: " + rating);
            System.out.println("Feedback: " + feedback);

            // Reset fields after submission
            doctorComboBox.getSelectionModel().clearSelection();
            ratingField.clear();
            feedbackField.clear();
        } else {
            System.out.println("Please fill in all fields.");
        }
    }

    @FXML
    private void handleBackButton() {
        try {
            // Navigate back to the AppointmentBooking screen
            Main.changeScene("/view/LoginDoctor.fxml");
        } catch (Exception e) {
            System.err.println("Error navigating to AppointmentBooking.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
