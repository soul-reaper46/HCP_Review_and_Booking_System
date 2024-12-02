package application;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isDoctor;
    
    public User(String email, String password, String firstName, String lastName, boolean isDoctor) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDoctor = isDoctor;
    }
    
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public boolean isDoctor() { return isDoctor; }
}