package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import application.Main;
import model.Data;
import model.Patient;

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
           
           Patient loggedInPatient = Data.getPatients().stream()
               .filter(p -> p.getEmail().equals(email) && p.getPassword().equals(password))
               .findFirst()
               .orElse(null);

           if (loggedInPatient != null) {
               showAlert("Success", "Login successful!", AlertType.INFORMATION);
               Data.setLoggedInUserId(loggedInPatient.getId());
               Main.changeScene("/view/PatientDashboard.fxml");
           } else {
               showAlert("Error", "Invalid credentials", AlertType.ERROR);
           }
       });
       
       SignUpLink.setOnMouseClicked(event -> {
           Main.changeScene("/view/SignupPatient.fxml");
       });
       
       DoctorLogInLink.setOnMouseClicked(event -> {
           Main.changeScene("/view/LoginDoctor.fxml");
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