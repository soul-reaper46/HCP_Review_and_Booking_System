package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Data {
    private static List<Patient> patients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static List<Feedback> feedbackList = new ArrayList<>(); // Added list for feedback
    private static int loggedInUserId;

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

        // Sample Appointments using Iterators
        LocalDate today = LocalDate.now();
        int appointmentId = 1;

        Iterator<Doctor> doctorIterator = doctors.iterator();
        while (doctorIterator.hasNext()) {
            Doctor doctor = doctorIterator.next();

            Iterator<Patient> patientIterator = patients.iterator();

            // Generate 6 appointments for each doctor
            for (int i = 0; i < 6; i++) {
                if (!patientIterator.hasNext()) {
                    patientIterator = patients.iterator(); // Reset patient iterator if it reaches the end
                }
                Patient patient = patientIterator.next();
                LocalDate appointmentDate = today.plusDays(i % 4); // Spread appointments over 3 dates

                appointments.add(new Appointment(
                        appointmentId++,
                        today,
                        appointmentDate,
                        doctor.getDoctorId(),
                        patient.getPatientId(),
                        "General Checkup",
                        "No previous medication"
                ));
            }
        }

        // Sample Past Appointments using Iterators
        LocalDate today1 = LocalDate.now();
        int pastAppointmentId = 100; // Start IDs for past appointments to differentiate them

        Iterator<Doctor> doctorIteratorForPast = doctors.iterator();
        while (doctorIteratorForPast.hasNext()) {
            Doctor doctor = doctorIteratorForPast.next();

            Iterator<Patient> patientIteratorForPast = patients.iterator();

            // Generate 6 past appointments for each doctor
            for (int i = 0; i < 6; i++) {
                if (!patientIteratorForPast.hasNext()) {
                    patientIteratorForPast = patients.iterator(); // Reset patient iterator if it reaches the end
                }
                Patient patient = patientIteratorForPast.next();
                LocalDate appointmentDate = today1.minusDays((i + 1) * 3); // Spread appointments 3 days apart in the past

                appointments.add(new Appointment(
                        pastAppointmentId++,
                        appointmentDate.minusDays(5), // Set booking date 5 days before the appointment date
                        appointmentDate,
                        doctor.getDoctorId(),
                        patient.getPatientId(),
                        "Follow-up Checkup",
                        "Previous medication prescribed"
                ));
            }
        }

        // Sample Feedback
        feedbackList.add(new Feedback(101, 5, 4, 5, 3, "Great experience with Dr. Smith, very professional!"));
        feedbackList.add(new Feedback(102, 4, 4, 4, 4, "Dr. Brown was friendly and helpful."));
        feedbackList.add(new Feedback(103, 5, 5, 5, 4, "Dr. White is very caring and knowledgeable."));
        // Add more feedback as needed
    }

    // Getter for patients
    public static List<Patient> getPatients() {
        return patients;
    }

    // Setter for adding a new patient
    public static void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Getter for doctors
    public static List<Doctor> getDoctors() {
        return doctors;
    }

    // Setter for adding a new doctor
    public static void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Getter for appointments
    public static List<Appointment> getAppointments() {
        return appointments;
    }

    // Setter for adding a new appointment
    public static void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Getter for feedbackList
    public static List<Feedback> getFeedbackList() {
        return feedbackList; // This is the new method for feedback
    }

    // Getter for loggedInUserId
    public static int getLoggedInUserId() {
        return loggedInUserId;
    }

    // Setter for loggedInUserId
    public static void setLoggedInUserId(int userId) {
        loggedInUserId = userId;
    }
}
