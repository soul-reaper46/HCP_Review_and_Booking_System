# HCP Review and Booking System

Our idea is to create a system that uses JavaFX for a user-friendly interface. This system will allow patients to search, compare, and book healthcare providers based on detailed performance metrics, key metrics include -
* Treatment Quality: Assessing the effectiveness of medical treatments provided, including patient outcomes, recovery rates, and success stories.
* Analysis Capabilities: Evaluating the diagnostic tools and technologies used for accurate detection and diagnosis of medical conditions.
* Detection Methods: Recommending providers based on their ability to detect diseases early and accurately using state-of-the-art screening techniques and technology.
* Hospitality: Assessing the quality of the overall patient experience, including facility comfort, cleanliness, staff interaction, waiting times, and additional services offered (e.g., patient support, quality care and accommodations).

The system will allow patients to input their medical needs, preferences, and any special requirements and allows users to look up a list of healthcare providers that best match their criteria. The system will include not only details about medical care (treatments, diagnostics, and detection) of the user but also feedback on the hospital's experience and services to ensure a holistic and pleasant healthcare experience.
## Authors

- [@SujaySN](https://github.com/soul-reaper46)
- [@GaganCM](https://github.com/Gagancm)
- [@SachinShet](https://github.com/SachinShet73)
- [@ShashankSH](https://github.com/)


## Documentation

[Initial Project File](https://drive.google.com/file/d/1aOCLhetY5hvB4Wjs7wbApuCMKoQDAHWh/view?usp=sharing)


## Features

* Rating System: HCPs are rated on diagnostic accuracy, treatment success, and patient satisfaction.
* Booking System: Patients can view provider availability and book appointments.
* Provider Lookup: Patients can search for providers by specialty, location, or rating, and view past appointments.
* Patient Feedback Integration: Patients can leave feedback, contributing to more comprehensive and UpToDate HCP ratings.


## License

[MIT](https://choosealicense.com/licenses/mit/)


## Project Structure

Below is the basic file structure of the project 

```bash
HealthcareBookingSystem/
├── src/
│   └── healthcarebooking/
│       ├── application/
│       │   └── Main.java
│       ├── controller/
│       │   ├── MainController.java
│       │   ├── SearchController.java
│       │   ├── BookingController.java
│       │   └── FeedbackController.java
|       ├── css/
|           └── styles.styl
│       ├── model/
│       │   ├── Patient.java
│       │   ├── HealthcareProvider.java
│       │   ├── Appointment.java
│       │   └── Feedback.java
│       ├── view/
│           ├── MainView.fxml
│           ├── SearchView.fxml
│           |── BookingView.fxml
|           |── Login.fxml
|           └── DashboardView.fxml
  
```


## Tech Stack

**Application:** Java, JavaFX, CSS

## Run Locally


Clone the project

```bash
  git clone https://github.com/soul-reaper46/HCP_Review_and_Booking_System.git
```

Go to the project directory

```bash
  cd HCP_Review_and_Booking
```
OR

* Download the zip file and extract all files.

THEN
* Open in eclipse and browse the extracted file and click open.
* Right click on the project name and select properties -> java build path, click on module path in libraries and click on add libraries button, select the javafx -> Apply and Close
* Again right click on project -> Rus as ->  Run configurations -> Under main Browse project as HCP_Review_and_Booking ->  browse main class as main – application , under arguments -> VM arguments ->paste the argument --add-modules javafx.controls,javafx.fxml and unselect both the check box below and select default under working directory, now just apply and run.
* As we run the project, it takes to the doctor login page.
* If patient is to be signed up or signed in please look at the upper right side of the page.
* When the page takes to patient login page please signup with your own credential else can sign in using a sample patient credentials which is provided below.
```bash
1.	Email - John.doe@example.com      password - password123
2.	Email - jane.smith@example.com    password - pass456
```
* After logging in first section will be appointment booking select the appropriate details and fill it and submit.
* Submitted appointment can be seen in current appointment section and already attended appointments will be stored in past appointment.
* Logout will take out of the patient dashboard and goes to doctor login page
* Credentials of all sample Doctors are :- 
```bash
1.	Email - smith@hospital.com           password - doc123
2.	Email - brown@hospital.com          password - brown456
3.	Email - white@hospital.com           password - white789
4.	Email - black@hospital.com            password - black123
5.	Email - green@hospital.com           password - green456
```
* Can login as doctor and see the present appointments and reason for the visit here.
* Can also view past appointments.
* When logged out it takes back to doctor login page.


