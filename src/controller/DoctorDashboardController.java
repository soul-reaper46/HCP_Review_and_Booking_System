package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DoctorDashboardController {

    @FXML
    private BorderPane rootPane;

    @FXML
    private Button btnHome, btnAppointments, btnPatients, btnLogout;

    @FXML
    public void initialize() {
        // Load the default page (Appointments)
        loadPage("AppointmentsViewDoctor");
    }

    @FXML
    private void handleHomeClick() {
        loadPage("AppointmentsViewDoctor");
    }

    @FXML
    private void handleAppointmentsClick() {
        loadPage("AppointmentsViewDoctor");
    }

    @FXML
    private void handlePatientsClick() {
        loadPage("PastAppointmentsViewDoctor");
    }

    @FXML
    private void handleLogoutClick() {
        // Implement logout functionality here
        System.out.println("Logout clicked!");
    }

    private void loadPage(String pageName) {
        try {
            // Load the requested page dynamically
            Node page = FXMLLoader.load(getClass().getResource("/view/" + pageName + ".fxml"));
            rootPane.setCenter(page); // Set the page in the center of the dashboard
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
