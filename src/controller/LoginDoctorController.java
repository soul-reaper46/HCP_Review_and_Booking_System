package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

public class LoginDoctorController {
    @FXML
    private TextField EmailTextField;
    
    @FXML
    private PasswordField PasswordTextField;
      
    @FXML
    private Button LoginButtonDoctor;
    
    @FXML
    private Text SignUpLink;
    
    @FXML
    private Text PatientLogInLink;
    
    @FXML
    public void initialize() {
        LoginButtonDoctor.setOnAction(event -> {
            String email = EmailTextField.getText();
            String password = PasswordTextField.getText();
            
            if(email.isEmpty() || password.isEmpty()) {
                System.out.println("Please enter both email and password");
                return;
            }
            System.out.println("Login attempt with email: " + email);
        });
        
        
        SignUpLink.setOnMouseClicked(event -> {
            System.out.println("Sign up clicked");
            Main.changeScene("SignupDoctor.fxml");
        });
        
        PatientLogInLink.setOnMouseClicked(event -> {
            System.out.println("Patient login clicked");
            Main.changeScene("LoginPatient.fxml");
        });
    }
}