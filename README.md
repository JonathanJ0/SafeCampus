# SafeCampus App

## Project Overview
SafeCampus is a mobile application designed to provide a platform for individuals to report harassment incidents, track the status of their reports, and receive support through a real-time chat feature. The app aims to create a safer environment for students and employees in academic and professional institutions.

Users can submit harassment reports (verbal abuse, bullying, sexual harassment, and cyber harassment), track the status of their reports, and engage in support chats with administrators or peers for help.

This project is part of a tech hackathon and is built using Android Studio for the mobile app and Render for backend hosting.

---

## Tech Stack Used

- **Frontend**: Android Studio (Java or Kotlin)
- **Backend**: Node.js, Express.js
- **Database**: MongoDB (via MongoDB Atlas)
- **Hosting**: Render (for backend)
- **SMTP**: Gmail for email configuration

---

## Setup & Installation Instructions

To run this project locally, follow the instructions below:

### Prerequisites
- [Node.js](https://nodejs.org/) (for backend)
- [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) account (for the database)
- [Android Studio](https://developer.android.com/studio) (for Android app development)

## Steps for Backend
1. Clone the repository:
   ```bash
   git clone https://github.com/jonathanJ0/safecampus.git
2. Navigate to the backend directory:
   ```bash
   cd safecampus/backend
3. Install the required dependencies:
   ```bash
   npm install
4. Set up your .env file with the necessary credentials (refer to the env section above).
5. Start the backend server:
   ```bash
   npm start
6. The backend will now be running at (https://safecampus-backend.onrender.com/)
## Steps for Android App
 - Open the project in Android Studio.
 - Sync the project with Gradle files.
 - Set up an Android device or emulator.
 - Run the app on your device or emulator.

### Key Features
Report Submission: Users can submit reports regarding various forms of harassment (verbal abuse, sexual harassment, bullying, and cyber harassment).
Track Report: Users can check the status of their reports by entering the unique report ID.
Support Chat: Users can send messages to get help or provide additional information regarding their incidents.
Anonymous Reporting: Users can choose to submit reports anonymously for added privacy.

## API Endpoints

1. **Submit a Report**  
   **POST** `/submit-report`  
   **Request Body**:
    ```json
   {
     "type": "verbal",
     "location": "Campus A",
     "time": "2024-12-01T14:00:00",
     "details": "Details of the incident...",
     "anonymous": true
   }
 **Response**:
  ```json
  {
     "reportId": "RPT-1234"
  }
