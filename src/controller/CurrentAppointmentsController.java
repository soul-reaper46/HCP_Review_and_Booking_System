package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import model.Appointment;
import model.Doctor;
import model.Data;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentAppointmentsController {
    @FXML
    private BorderPane rootPane;

    @FXML
    private TableView<Appointment> tblCurrentAppointments;

    @FXML
    private TableColumn<Appointment, String> colDoctorName;

    @FXML
    private TableColumn<Appointment, LocalDate> colAppointmentDate;

    @FXML
    private TableColumn<Appointment, String> colAppointmentTime;

    public void initialize() {
        // Set up column cell value factories
        colDoctorName.setCellValueFactory(cellData -> {
            // Find the doctor name based on the doctor ID
            int doctorId = cellData.getValue().getDoctorId();
            Doctor doctor = Data.getDoctors().stream()
                .filter(d -> d.getDoctorId() == doctorId)
                .findFirst()
                .orElse(null);
            
            return new javafx.beans.property.SimpleStringProperty(
                doctor != null ? doctor.getName() : "Unknown Doctor"
            );
        });

        colAppointmentDate.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getAppointmentDate())
        );

        

        // Load current appointments
        loadCurrentAppointments();
    }

    private void loadCurrentAppointments() {
        int loggedInPatientId = Data.getLoggedInUserId();
        List<Appointment> currentAppointments = Data.getAppointments().stream()
            .filter(appointment ->
                appointment.getPatientId() == loggedInPatientId &&
                appointment.getAppointmentDate().isAfter(LocalDate.now().minusDays(1)))
            .collect(Collectors.toList());

        ObservableList<Appointment> observableList = FXCollections.observableArrayList(currentAppointments);
        tblCurrentAppointments.setItems(observableList);
    }

    @FXML
    private void handleBackToDashboard(ActionEvent event) {
        try {
            // Or if you're using the event source:
            BorderPane parentPane = (BorderPane)((Node)event.getSource()).getScene().getRoot();
            Parent dashboardContent = FXMLLoader.load(getClass().getResource("/view/PatientDashboard.fxml"));
            parentPane.setCenter(dashboardContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleHomeClick(ActionEvent event) {
        handleBackToDashboard(event);
    }
}