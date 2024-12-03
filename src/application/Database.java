package application;

import model.Data;
import model.Doctor;
import model.Patient;

public class Database {
    private static Database instance;
    
    private Database() {}
    
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
    public void addUser(String email, String password, String firstName, String lastName, boolean isDoctor) {
        if (isDoctor) {
            Doctor doctor = new Doctor(firstName + " " + lastName, "", email, password, 0, "", 0.0, "", "", "", "", 0.0, 0);
            Data.addDoctor(doctor);
        } else {
            Patient patient = new Patient(firstName + " " + lastName, "", email, password, 0, 0, 0, "", null, "", "", "", "");
            Data.addPatient(patient);
        }
    }
    
    public boolean authenticateUser(String email, String password, boolean isDoctor) {
        if (isDoctor) {
            return Data.getDoctors().stream()
                .anyMatch(d -> d.getEmail().equals(email) && d.getPassword().equals(password));
        } else {
            return Data.getPatients().stream()
                .anyMatch(p -> p.getEmail().equals(email) && p.getPassword().equals(password));
        }
    }
}