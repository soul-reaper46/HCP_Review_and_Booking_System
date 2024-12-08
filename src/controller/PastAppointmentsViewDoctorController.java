package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Appointment;
import model.Data;
import model.Doctor;
import model.Patient;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PastAppointmentsViewDoctorController {

    @FXML
    private TableView<Appointment> pastAppointmentsTable;

    @FXML
    private TableColumn<Appointment, Integer> appointmentIdColumn;

    @FXML
    private TableColumn<Appointment, String> doctorNameColumn;

    @FXML
    private TableColumn<Appointment, String> patientNameColumn;

    @FXML
    private TableColumn<Appointment, LocalDate> dateColumn;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        // Bind columns to Appointment properties
    	appointmentIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));
    	doctorNameColumn.setCellValueFactory(data -> new SimpleStringProperty(getDoctorNameById(data.getValue().getDoctorId())));
    	patientNameColumn.setCellValueFactory(data -> new SimpleStringProperty(getPatientNameById(data.getValue().getPatientId())));
    	dateColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getAppointmentDate()));

        // Load only past appointments
        List<Appointment> pastAppointments = Data.getAppointments().stream()
                .filter(appointment -> appointment.getAppointmentDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        // Add past appointments to the table
        pastAppointmentsTable.getItems().addAll(pastAppointments);
    }
    private String getDoctorNameById(int doctorId) {
        Optional<Doctor> doctor = Data.getDoctors().stream()
                .filter(d -> d.getDoctorId() == doctorId)
                .findFirst();
        return doctor.map(Doctor::getName).orElse("Unknown");
    }

    private String getPatientNameById(int patientId) {
        Optional<Patient> patient = Data.getPatients().stream()
                .filter(p -> p.getPatientId() == patientId)
                .findFirst();
        return patient.map(Patient::getName).orElse("Unknown");
    }


    @FXML
    public void handleBackAction() {
        //TODO
    }
}
