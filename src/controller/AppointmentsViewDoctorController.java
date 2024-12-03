package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppointmentsViewDoctorController {

    // Top bar and Date Buttons container
    @FXML
    private HBox topbar;

    @FXML
    private HBox dateButtonsContainer;

    // Date buttons
    @FXML
    private Button btnToday, btnDate1, btnDate2, btnDate3, btnDate4;

    @FXML
    public void initialize() {
        // Ensure the top bar and date buttons container are styled correctly
        if (topbar != null) {
            topbar.getStyleClass().add("topbar");
        }
        if (dateButtonsContainer != null) {
            dateButtonsContainer.getStyleClass().add("date-buttons");
        }

        // Set "Today" as the current day
        btnToday.setText("Today");

        // Get current date and set next 4 days
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

        btnDate1.setText(currentDate.plusDays(1).format(formatter));
        btnDate2.setText(currentDate.plusDays(2).format(formatter));
        btnDate3.setText(currentDate.plusDays(3).format(formatter));
        btnDate4.setText(currentDate.plusDays(4).format(formatter));
    }

    @FXML
    private void handleDateClick() {
        // Handle date button click events here
        System.out.println("Date button clicked!");
    }
}
