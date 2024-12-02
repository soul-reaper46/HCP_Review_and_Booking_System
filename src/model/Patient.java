package model;

import java.time.LocalDate;

public class Patient extends Person {
    private int patientId;
    private double height;
    private double weight;
    private double bmi;
    private String allergies;
    private LocalDate dob;
    private String bloodGroup;
    private String prescription;
    private String diagnosis;
    private String currentTreatedBy;

    public Patient(String name, String phoneNumber, String email, String password, int patientId, double height,
                   double weight, String allergies, LocalDate dob, String bloodGroup, String prescription,
                   String diagnosis, String currentTreatedBy) {
        super(name, phoneNumber, email, password);
        this.patientId = patientId;
        this.height = height;
        this.weight = weight;
        this.bmi = calculateBMI(height, weight);
        this.allergies = allergies;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.prescription = prescription;
        this.diagnosis = diagnosis;
        this.currentTreatedBy = currentTreatedBy;
    }

    // Calculate BMI
    private double calculateBMI(double height, double weight) {
        return weight / ((height / 100) * (height / 100)); // Assuming height in cm
    }

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getCurrentTreatedBy() {
		return currentTreatedBy;
	}

	public void setCurrentTreatedBy(String currentTreatedBy) {
		this.currentTreatedBy = currentTreatedBy;
	}

}
