package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import application.Main;
import application.Database;

public class SignupDoctorController {
    @FXML private TextField EmailTextField;
    @FXML private TextField EmailTextField11;  // First Name
    @FXML private TextField EmailTextField1;   // Last Name
    @FXML private PasswordField PasswordTextField;
    @FXML private Button SignUpButtonDoctor;
    @FXML private Text LogInLink;
    @FXML private Text PatientLogInLink;
    
    @FXML
    public void initialize() {
        SignUpButtonDoctor.setOnAction(event -> handleSignUp());
        LogInLink.setOnMouseClicked(event -> Main.changeScene("/view/LoginDoctor.fxml"));
        PatientLogInLink.setOnMouseClicked(event -> Main.changeScene("/view/LoginPatient.fxml"));
    }
    
    private void handleSignUp() {
        String firstName = EmailTextField11.getText().trim();
        String lastName = EmailTextField1.getText().trim();
        String email = EmailTextField.getText().trim();
        String password = PasswordTextField.getText();
        
        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please fill all fields", AlertType.ERROR);
            return;
        }
        
        if(password.length() < 6) {
            showAlert("Error", "Password must be at least 6 characters", AlertType.ERROR);
            return;
        }
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            showAlert("Error", "Please enter a valid email address", AlertType.ERROR);
            return;
        }
        
        try {
            Database.getInstance().addUser(email, password, firstName, lastName, true);
            showAlert("Success", "Account created successfully! Please login with your credentials.", AlertType.INFORMATION);
            Main.changeScene("/view/LoginDoctor.fxml");
        } catch (RuntimeException e) {
            showAlert("Error", e.getMessage(), AlertType.ERROR);
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