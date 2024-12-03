package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class PatientDashboardController {

    @FXML
    private Label navbarTitle;

    @FXML
    private Label welcomeMessage;

    @FXML
    private TableView<?> tblCurrentAppointments;

    @FXML
    private TableView<?> tblPastAppointments;

    @FXML
    private TextField txtPatientName;

    @FXML
    private TextField txtAppointmentDate;

    @FXML
    private TextField txtAppointmentTime;

    @FXML
    private Button btnBookNewAppointment;

    @FXML
    private Button btnCurrentAppointments;

    @FXML
    private Button btnPatients;

    @FXML
    private Button btnReviewDoctor;

    @FXML
    private Button btnLogout;

    // This method handles booking a new appointment
    @FXML
    private void handleBookNewAppointmentClick(ActionEvent event) {
        System.out.println("Book New Appointment clicked.");
        // Add your logic to open the new appointment booking section
    }

    // This method handles viewing the current appointments
    @FXML
    private void handleAppointmentsClick(ActionEvent event) {
        System.out.println("Viewing current appointments...");
        // Example: Fetch current appointments from a database and populate tblCurrentAppointments
    }

    // This method handles viewing past appointments
    @FXML
    private void handlePatientsClick(ActionEvent event) {
        System.out.println("Viewing past appointments...");
        // Example: Fetch past appointments from a database and populate tblPastAppointments
    }

    // This method handles reviewing a doctor
    @FXML
    private void handleReviewDoctorClick(ActionEvent event) {
        System.out.println("Review Doctor clicked.");
        // Add your logic to review a doctor
    }

    // This method handles registering a new appointment
    @FXML
    private void handleRegisterAppointmentClick(ActionEvent event) {
        String patientName = txtPatientName.getText();
        String appointmentDate = txtAppointmentDate.getText();
        String appointmentTime = txtAppointmentTime.getText();

        if (patientName.isEmpty() || appointmentDate.isEmpty() || appointmentTime.isEmpty()) {
            System.out.println("Please fill in all fields to register an appointment.");
            return;
        }

        // Add your logic to register the appointment
        System.out.println("Registering new appointment for " + patientName + " on " + appointmentDate + " at " + appointmentTime);
        
        // Example: Save the appointment in a database
        
        // Clear the form after successful registration
        txtPatientName.clear();
        txtAppointmentDate.clear();
        txtAppointmentTime.clear();
    }

    // This method handles logging out and loads the "LoginDoctor.fxml" screen
    @FXML
    private void handleLogoutClick(ActionEvent event) {
        System.out.println("Logging out...");
        
        try {
            // Load the LoginDoctor.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginDoctor.fxml"));
            Parent loginRoot = loader.load();

            // Get the current stage (window) and set the new scene (login scene)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene loginScene = new Scene(loginRoot);
            stage.setScene(loginScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading the LoginDoctor.fxml file.");
        }
    }
}
