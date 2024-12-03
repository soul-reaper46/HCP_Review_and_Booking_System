package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import model.Appointment;
import model.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsViewDoctorController {

    @FXML
    private VBox accordionContainer;

    @FXML
    private DatePicker datePicker;

    private List<Appointment> appointments;

    @FXML
    public void initialize() {
        // Fetch the appointments from Data.java
        appointments = Data.getAppointments();
        
        // Set the DatePicker to today's date
        datePicker.setValue(LocalDate.now());
        
        // Load today's appointments
        loadAppointmentsForDate(LocalDate.now());
    }

    @FXML
    private void handleDateChange() {
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate != null) {
            loadAppointmentsForDate(selectedDate);
        }
    }

    private void loadAppointmentsForDate(LocalDate date) {
        accordionContainer.getChildren().clear();
        
        // Filter appointments by date
        List<Appointment> filteredAppointments = filterAppointmentsByDate(date);

        // Create TitledPanes for each appointment
        for (Appointment appointment : filteredAppointments) {
            TitledPane pane = createAppointmentAccordion(appointment);
            accordionContainer.getChildren().add(pane);
        }
    }

    private List<Appointment> filterAppointmentsByDate(LocalDate date) {
        List<Appointment> filtered = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentDate().isEqual(date)) {
                filtered.add(appointment);
            }
        }
        return filtered;
    }

    private TitledPane createAppointmentAccordion(Appointment appointment) {
        // Extract patient name dynamically if available
        String patientName = "Patient ID: " + appointment.getPatientId();

        TitledPane titledPane = new TitledPane();
        titledPane.setText(patientName);

        VBox card = new VBox(10);
        card.setPadding(new javafx.geometry.Insets(10));
        card.getChildren().addAll(
            new Label("Complaint: " + appointment.getComplaint()),
            new Label("Previous Medication: " + appointment.getPreviousMedication()),
            new Label("Booking Date: " + appointment.getBookingDate().toString()),
            new Label("Appointment Date: " + appointment.getAppointmentDate().toString())
        );

        titledPane.setContent(card);
        titledPane.setExpanded(false);
        return titledPane;
    }
}
