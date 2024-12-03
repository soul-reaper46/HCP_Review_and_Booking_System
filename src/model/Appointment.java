package model;

import java.time.LocalDate;

public class Appointment {
    private int id; // Unique appointment ID
    private LocalDate bookingDate; // Date the appointment was booked
    private LocalDate appointmentDate; // Date of the actual appointment
    private int doctorId; // ID of the doctor
    private int patientId; // ID of the patient
    private String complaint; // Patient's complaint
    private String previousMedication; // Details of previous medication

    // Constructor
    public Appointment(int id, LocalDate bookingDate, LocalDate appointmentDate, int doctorId, int patientId, String complaint, String previousMedication) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.appointmentDate = appointmentDate;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.complaint = complaint;
        this.previousMedication = previousMedication;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getPreviousMedication() {
        return previousMedication;
    }

    public void setPreviousMedication(String previousMedication) {
        this.previousMedication = previousMedication;
    }

    // Overriding toString() for debugging and display purposes
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", appointmentDate=" + appointmentDate +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", complaint='" + complaint + '\'' +
                ", previousMedication='" + previousMedication + '\'' +
                '}';
    }
}
