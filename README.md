# Hotel Booking System 

## Overview

This project is a simple Java-based hotel booking system developed as part of the Software Development with Java module. The application demonstrates the use of object-oriented programming principles, basic graphical user interface development using Swing, and unit testing with JUnit.

The system allows users to view available hotel rooms, create reservations, and receive feedback for both successful and invalid operations. It is designed as a prototype to focus on core system logic rather than advanced user interface features.

---

## Features

* Display a list of available hotel rooms
* Create a reservation for a selected room
* Prevent double bookings through validation
* Provide clear feedback messages for successful actions and errors
* Simple graphical user interface built with Java Swing
* Unit testing using JUnit to verify core functionality

---

## Project Structure

```
src
├── model
│   ├── Room.java
│   └── Reservation.java
├── service
│   └── HotelManager.java
├── ui
│   └── HotelGUI.java
├── test
│   └── HotelManagerTest.java
└── Main.java
```

### Description of Packages

* model: Contains core domain classes representing rooms and reservations.
* service: Contains business logic for managing rooms and reservations.
* ui: Contains the Swing-based graphical user interface.
* test: Contains JUnit tests for validating system behaviour.
* Main.java: Demonstrates the system workflow through console output.

---

## Technologies Used

* Java (JDK 17)
* Java Swing (GUI)
* JUnit 5 (Unit Testing)
* IntelliJ IDEA

---

## How to Run the Application

1. Open the project in IntelliJ IDEA.
2. Ensure JDK 17 is configured.
3. Run `HotelGUI.java` to launch the graphical user interface.
4. Run `Main.java` to see the system workflow via console output.
5. Run `HotelManagerTest.java` to execute unit tests.

---

## Testing

Unit tests were implemented using JUnit to verify:

* Reservation creation
* Room availability updates
* Reservation cancellation
* Price calculation logic

All tests pass successfully, confirming correct system behavior.

---

## Notes

This project was intentionally implemented as a simple prototype. The focus was on correct object-oriented design, validation, and testing rather than complex UI interactions. The system can be extended in the future to include additional features such as user input forms, database storage, or a more advanced graphical interface.

---

## Author

Maya Mnaizel


