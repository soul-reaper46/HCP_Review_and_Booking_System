package model;

public class Feedback {
    private int doctorId;
    private int analysisRating;
    private int treatmentRating;
    private int behaviourRating;
    private int costRating;
    private String feedback;

    public Feedback(int doctorId, int analysisRating, int treatmentRating, int behaviourRating, int costRating, String feedback) {
        this.doctorId = doctorId;
        this.analysisRating = analysisRating;
        this.treatmentRating = treatmentRating;
        this.behaviourRating = behaviourRating;
        this.costRating = costRating;
        this.feedback = feedback;
    }

    // Getters and setters for all fields
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getAnalysisRating() {
        return analysisRating;
    }

    public void setAnalysisRating(int analysisRating) {
        this.analysisRating = analysisRating;
    }

    public int getTreatmentRating() {
        return treatmentRating;
    }

    public void setTreatmentRating(int treatmentRating) {
        this.treatmentRating = treatmentRating;
    }

    public int getBehaviourRating() {
        return behaviourRating;
    }

    public void setBehaviourRating(int behaviourRating) {
        this.behaviourRating = behaviourRating;
    }

    public int getCostRating() {
        return costRating;
    }

    public void setCostRating(int costRating) {
        this.costRating = costRating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "doctorId=" + doctorId +
                ", analysisRating=" + analysisRating +
                ", treatmentRating=" + treatmentRating +
                ", behaviourRating=" + behaviourRating +
                ", costRating=" + costRating +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
