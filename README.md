
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
└── resources/
    ├── images/
    ├── css/
        └── styles.styl
```
    
## Tech Stack

**Application:** Java, JavaFX, CSS

