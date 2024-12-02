package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;

public class SignupPatientController {
    @FXML private TextField EmailTextField;
    @FXML private TextField EmailTextField1;
    @FXML private TextField EmailTextField11;
    @FXML private PasswordField PasswordTextField;
    @FXML private Button SignUpButtonPatient;
    @FXML private Text LogInLink;
    @FXML private Text DoctorLogInLink;
    
    @FXML
    public void initialize() {
        SignUpButtonPatient.setOnAction(event -> handleSignUp());
        LogInLink.setOnMouseClicked(event -> Main.changeScene("LoginPatient.fxml"));
        DoctorLogInLink.setOnMouseClicked(event -> Main.changeScene("LoginDoctor.fxml"));
    }
    
    private void handleSignUp() {
        String firstName = EmailTextField1.getText().trim();
        String lastName = EmailTextField11.getText().trim();
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
            Database.getInstance().addUser(email, password, firstName, lastName, false);
            showAlert("Success", "Account created successfully! Please login with your credentials.", AlertType.INFORMATION);
            Main.changeScene("LoginPatient.fxml");
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