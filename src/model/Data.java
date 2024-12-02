package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Data {
	private static ArrayList<Patient> patients = new ArrayList<>();
	private static ArrayList<Doctor> doctors = new ArrayList<>();

	// Static block to initialize the data
	static {
		// Sample Patients
		patients.add(new Patient("John Doe", "1234567890", "john.doe@example.com", "password123", 1, 180, 75, "Peanuts",
				LocalDate.of(1990, 5, 20), "O+", "Paracetamol", "Flu", "Dr. Smith"));
		patients.add(new Patient("Jane Smith", "9876543210", "jane.smith@example.com", "pass456", 2, 165, 60, "Dust",
				LocalDate.of(1985, 7, 15), "A-", "Ibuprofen", "Allergy", "Dr. Brown"));
		patients.add(new Patient("Emily Johnson", "1122334455", "emily.johnson@example.com", "emily123", 3, 170, 68,
				"None", LocalDate.of(1992, 3, 12), "B+", "Amoxicillin", "Infection", "Dr. White"));
		patients.add(new Patient("Michael Brown", "2233445566", "michael.brown@example.com", "michael123", 4, 175, 80,
				"Gluten", LocalDate.of(1988, 11, 8), "AB+", "Antihistamines", "Asthma", "Dr. Black"));
		patients.add(new Patient("Sophia Lee", "3344556677", "sophia.lee@example.com", "sophia123", 5, 160, 55,
				"Lactose", LocalDate.of(1995, 9, 22), "O-", "Vitamin C", "Cold", "Dr. Green"));

		// Sample Doctors
		doctors.add(new Doctor("Dr. Smith", "4455667788", "smith@hospital.com", "doc123", 101, "L-1234 (Cardiology)",
				4.8, "Heart Specialist", "ECG and blood tests", "Angioplasty", "Polite", 500.0, 10));
		doctors.add(new Doctor("Dr. Brown", "5566778899", "brown@hospital.com", "brown456", 102, "L-2345 (Dermatology)",
				4.5, "Skin Specialist", "Skin biopsy", "Allergy treatment", "Friendly", 400.0, 8));
		doctors.add(new Doctor("Dr. White", "6677889900", "white@hospital.com", "white789", 103, "L-3456 (Pediatrics)",
				4.7, "Child Specialist", "Physical exam", "Vaccination", "Caring", 300.0, 7));
		doctors.add(new Doctor("Dr. Black", "7788990011", "black@hospital.com", "black123", 104, "L-4567 (Pulmonology)",
				4.6, "Lung Specialist", "Spirometry", "Asthma management", "Professional", 450.0, 9));
		doctors.add(new Doctor("Dr. Green", "8899001122", "green@hospital.com", "green456", 105,
				"L-5678 (General Practice)", 4.9, "General Practitioner", "General checkup", "Common ailments",
				"Compassionate", 250.0, 12));
	}

	// Getter for patients
	public static ArrayList<Patient> getPatients() {
		return patients;
	}

	// Setter for adding a new patient
	public static void addPatient(Patient patient) {
		patients.add(patient);
	}

	// Getter for doctors
	public static ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	// Setter for adding a new doctor
	public static void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
}
