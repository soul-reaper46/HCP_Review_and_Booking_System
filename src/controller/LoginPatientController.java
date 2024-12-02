package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginPatientController {
   @FXML private TextField EmailTextField;
   @FXML private PasswordField PasswordTextField;
   @FXML private Button LoginButtonPatient;
   @FXML private Text SignUpLink;
   @FXML private Text DoctorLogInLink;
   
   @FXML
   public void initialize() {
       LoginButtonPatient.setOnAction(event -> {
           String email = EmailTextField.getText().trim();
           String password = PasswordTextField.getText();
           
           if(email.isEmpty() || password.isEmpty()) {
               showAlert("Error", "Please enter both email and password", AlertType.ERROR);
               return;
           }
           
           if(Database.getInstance().authenticateUser(email, password, false)) {
               showAlert("Success", "Login successful!", AlertType.INFORMATION);
               // Add navigation to patient dashboard here
           } else {
               showAlert("Error", "Invalid credentials", AlertType.ERROR);
           }
       });
       
       SignUpLink.setOnMouseClicked(event -> {
           Main.changeScene("SignupPatient.fxml");
       });
       
       DoctorLogInLink.setOnMouseClicked(event -> {
           Main.changeScene("LoginDoctor.fxml");
       });
   }
   
   private void showAlert(String title, String content, AlertType type) {
       Alert alert = new Alert(type);
       alert.setTitle(title);
       alert.setHeaderText(null);
       alert.setContentText(content);
       alert.showAndWait();
   }
}