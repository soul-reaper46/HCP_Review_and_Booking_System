package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginDoctorController {
    @FXML private TextField EmailTextField;
    @FXML private PasswordField PasswordTextField;
    @FXML private Button LoginButtonDoctor;
    @FXML private Text SignUpLink;
    @FXML private Text PatientLogInLink;
    
    @FXML
    public void initialize() {
        LoginButtonDoctor.setOnAction(event -> {
            String email = EmailTextField.getText();
            String password = PasswordTextField.getText();
            
            if(email.isEmpty() || password.isEmpty()) {
                showAlert("Error", "Please enter both email and password");
                return;
            }
            
            if(Database.getInstance().authenticateUser(email, password, true)) {
                showAlert("Success", "Login successful!");
                // Add navigation to doctor dashboard here
            } else {
                showAlert("Error", "Invalid credentials");
            }
        });
        
        SignUpLink.setOnMouseClicked(event -> {
            Main.changeScene("SignupDoctor.fxml");
        });
        
        PatientLogInLink.setOnMouseClicked(event -> {
            Main.changeScene("LoginPatient.fxml");
        });
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}