package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignupPatientController {
    @FXML
    private TextField EmailTextField;
    
    @FXML
    private TextField EmailTextField1;
    
    @FXML
    private TextField EmailTextField11;
    
    @FXML
    private Button SignUpButtonDoctor;
    
    @FXML
    private Text LogInLink;
    
    @FXML
    private Text PatientLogInLink;
    
    @FXML
    public void initialize() {
        SignUpButtonDoctor.setOnAction(event -> {
            String firstName = EmailTextField1.getText();
            String lastName = EmailTextField11.getText();
            String email = EmailTextField.getText();
            
            if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                System.out.println("Please fill all fields");
                return;
            }
            System.out.println("Sign up attempt for: " + firstName + " " + lastName);
            Main.changeScene("LoginPatient.fxml");
        });
        
        LogInLink.setOnMouseClicked(event -> {
            System.out.println("Login clicked");
            Main.changeScene("LoginPatient.fxml");
        });
        
        PatientLogInLink.setOnMouseClicked(event -> {
            System.out.println("Patient login clicked");
            Main.changeScene("LoginPatient.fxml");
        });
    }
}