package model;

public class Doctor extends Person {
    private int doctorId;
    private String licenseNumber; // Includes department info
    private double overallRating;
    private String analysis;
    private String patientWorkup;
    private String treatment;
    private String behaviour;
    private double cost;
    private int experienceYears;

    public Doctor(String name, String phoneNumber, String email, String password, int doctorId, String licenseNumber,
                  double overallRating, String analysis, String patientWorkup, String treatment, String behaviour,
                  double cost, int experienceYears) {
        super(name, phoneNumber, email, password);
        this.doctorId = doctorId;
        this.licenseNumber = licenseNumber;
        this.overallRating = overallRating;
        this.analysis = analysis;
        this.patientWorkup = patientWorkup;
        this.treatment = treatment;
        this.behaviour = behaviour;
        this.cost = cost;
        this.experienceYears = experienceYears;
    }

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public double getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(double overallRating) {
		this.overallRating = overallRating;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getPatientWorkup() {
		return patientWorkup;
	}

	public void setPatientWorkup(String patientWorkup) {
		this.patientWorkup = patientWorkup;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

    
}
