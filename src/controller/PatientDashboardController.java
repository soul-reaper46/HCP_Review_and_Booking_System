package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Appointment;
import model.Data;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import application.Main;

public class PatientDashboardController {
    @FXML
    private BorderPane rootPane;

    @FXML
    private Label navbarTitle;

    @FXML
    private TableView<Appointment> tblCurrentAppointments;

    @FXML
    private TableView<Appointment> tblPastAppointments;

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

    public void initialize() {
        // Load AppointmentBooking.fxml by default
        loadPage("AppointmentBooking");
    }

    @FXML
    private void handleBookNewAppointmentClick(ActionEvent event) {
        loadPage("AppointmentBooking");
    }

    @FXML
    private void handleAppointmentsClick(ActionEvent event) {
        try {
            // Load the Current Appointments view
            Parent currentAppointments = FXMLLoader.load(getClass().getResource("/view/CurrentAppointments.fxml"));
            
            // Set the Current Appointments view in the center of the BorderPane
            rootPane.setCenter(currentAppointments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePatientsClick(ActionEvent event) {
        try {
            Parent pastAppointments = FXMLLoader.load(getClass().getResource("/view/PastAppointments.fxml"));
            BorderPane parentPane = (BorderPane)((Node)event.getSource()).getScene().getRoot();
            parentPane.setCenter(pastAppointments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleReviewDoctorClick(ActionEvent event) {
        loadPage("DoctorRating");
    }

    @FXML
    private void handleRegisterAppointmentClick(ActionEvent event) {
        String patientName = txtPatientName.getText();
        String appointmentDate = txtAppointmentDate.getText();
        String appointmentTime = txtAppointmentTime.getText();

        if (patientName.isEmpty() || appointmentDate.isEmpty() || appointmentTime.isEmpty()) {
            System.out.println("Please fill in all fields to register an appointment.");
            return;
        }

        // Logic for registering appointment
        System.out.println("Registering new appointment for " + patientName + " on " + appointmentDate + " at " + appointmentTime);

        
        // Clear the form
        txtPatientName.clear();
        txtAppointmentDate.clear();
        txtAppointmentTime.clear();
    }

    @FXML
    private void handleLogoutClick(ActionEvent event) {
        System.out.println("Logging out...");
        Main.changeScene("/view/LoginDoctor.fxml");
    }

    private void loadPage(String pageName) {
        try {
            Node page = FXMLLoader.load(getClass().getResource("/view/" + pageName + ".fxml"));
            rootPane.setCenter(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCurrentAppointments() {
        int loggedInPatientId = Data.getLoggedInUserId();
        List<Appointment> currentAppointments = Data.getAppointments().stream()
                .filter(appointment -> appointment.getPatientId() == loggedInPatientId &&
                        appointment.getAppointmentDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());

        ObservableList<Appointment> observableList = FXCollections.observableArrayList(currentAppointments);
        tblCurrentAppointments.setItems(observableList);
    }

    private void loadPastAppointments() {
        int loggedInPatientId = Data.getLoggedInUserId();
        List<Appointment> pastAppointments = Data.getAppointments().stream()
                .filter(appointment -> appointment.getPatientId() == loggedInPatientId &&
                        appointment.getAppointmentDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        ObservableList<Appointment> observableList = FXCollections.observableArrayList(pastAppointments);
        tblPastAppointments.setItems(observableList);
    }
}
