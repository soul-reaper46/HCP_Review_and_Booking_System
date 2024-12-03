package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import model.Data;
import model.Appointment;
import model.Doctor;
import model.Patient;
import application.Main;

public class AppointmentBookingController {

    @FXML private ComboBox<String> doctorComboBox;
    @FXML private ComboBox<String> appointmentTypeComboBox;
    @FXML private TextField patientName;
    @FXML private TextField patientEmail;
    @FXML private DatePicker appointmentDatePicker;
    @FXML private TextField appointmentTime;
    @FXML private Button bookAppointmentButton;
    @FXML private Button backButton;

    @FXML
    private void initialize() {
        // Populate doctorComboBox with doctors from Data
        ObservableList<String> doctorNames = FXCollections.observableArrayList();
        for (Doctor doctor : Data.getDoctors()) {
            doctorNames.add(doctor.getName());
        }
        doctorComboBox.setItems(doctorNames);

        // Populate appointmentTypeComboBox with options
        ObservableList<String> appointmentTypes = FXCollections.observableArrayList("Consultation", "Check-up", "Emergency");
        appointmentTypeComboBox.setItems(appointmentTypes);

        // Set non-editable patient info fields
        int loggedInPatientId = Data.getLoggedInUserId();
        Patient loggedInPatient = Data.getPatients().stream()
            .filter(p -> p.getPatientId() == loggedInPatientId)
            .findFirst()
            .orElse(null);

        if (loggedInPatient != null) {
            patientName.setText(loggedInPatient.getName());
            patientEmail.setText(loggedInPatient.getEmail());
            patientName.setEditable(false);
            patientEmail.setEditable(false);
        }
    }

    @FXML
    private void handleBookAppointment() {
        String selectedDoctorName = doctorComboBox.getValue();
        String selectedAppointmentType = appointmentTypeComboBox.getValue();
        LocalDate selectedDate = appointmentDatePicker.getValue();
        String time = appointmentTime.getText();

        if (selectedDoctorName == null || selectedAppointmentType == null || selectedDate == null || time.isEmpty()) {
            showAlert("Error", "Please fill all the fields", AlertType.ERROR);
            return;
        }

        // Retrieve the doctor object based on selected name
        Doctor selectedDoctor = Data.getDoctors().stream()
            .filter(d -> d.getName().equals(selectedDoctorName))
            .findFirst()
            .orElse(null);

        if (selectedDoctor == null) {
            showAlert("Error", "Doctor not found", AlertType.ERROR);
            return;
        }

        // Create a new appointment and add it to the Data class
        int loggedInPatientId = Data.getLoggedInUserId();
        Patient loggedInPatient = Data.getPatients().stream()
            .filter(p -> p.getPatientId() == loggedInPatientId)
            .findFirst()
            .orElse(null);

        if (loggedInPatient != null) {
            int appointmentId = Data.getAppointments().size() + 1;  // Generate a new appointment ID
            Appointment newAppointment = new Appointment(
                appointmentId, LocalDate.now(), selectedDate, selectedDoctor.getDoctorId(),
                loggedInPatient.getPatientId(), selectedAppointmentType, "No previous medication"
            );

            Data.addAppointment(newAppointment);
            showAlert("Success", "Appointment booked successfully!", AlertType.INFORMATION);
            Main.changeScene("/view/DoctorRating.fxml");  // Redirect to the Doctor Rating page
        } else {
            showAlert("Error", "Patient not found", AlertType.ERROR);
        }
    }

    @FXML
    private void handleBackButton() {
        try {
            Main.changeScene("/view/DoctorRating.fxml");
        } catch (Exception e) {
            showAlert("Error", "Navigation failed", AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
