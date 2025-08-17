# Westminster Skin Consultation Management System

## Project Description
This project is a Java-based desktop application designed to manage a skin consultation clinic efficiently. The system provides both a Command-Line Interface (CLI) for administrative tasks and a comprehensive Graphical User Interface (GUI) for managing doctors, patients, and consultations.

## The application ensures:

Complete doctor management (add, delete, view, sort)
Patient registration and consultation booking
Conflict detection and automatic doctor reassignment
Data persistence through file storage
Intuitive GUI with table displays and form inputs
Image upload and encryption for consultation records

Developed as part of coursework for the Westminster University Object-Oriented Programming module.

## Project Structure

```
20210246_Sunethma_oop_cw/
├── oop_final_cw_submission/
│   └── src/
│       ├── ConsoleMenuImplementation/
│       │   ├── Consultation.java
│       │   ├── Doctor.java
│       │   ├── Main.java (Entry point for console application)
│       │   ├── Patient.java
│       │   ├── Person.java
│       │   ├── SkinConsultationManager.java (Interface)
│       │   └── WestminsterSkinConsultationManager.java
│       └── GuiImplementation/
│           ├── DoctorTable.java
│           ├── MainGUI.java
│           ├── PatientDetailsForm.java
│           ├── DisplayTableForm.java (Consultation history viewer)
│           └── DisplayStatus.java (Consultation status display)
├── out/ (compiled classes)
├── Doctor.txt (data persistence file)
├── Doctor_details.txt (formatted doctor details)
└── Encrypted.jpg (encrypted patient images)
```

## Key Features

### Console Menu Implementation

#### Doctor Management System
```
Add doctors with full validation (license number uniqueness)

Delete doctors by medical license number

Display doctors sorted alphabetically by surname

Maximum capacity of 10 doctors

Data persistence to text files
```

#### File Operations
```
Save doctor details in human-readable format

Load previous session data automatically on startup

Export consultation records
```
### GUI Implementation

#### Doctor Management Interface
```
Interactive table displaying all registered doctors

Click-to-select doctor information

Alphabetical sorting functionality

Real-time data refresh capabilities
```

#### Consultation Booking System
```
Date picker for consultation scheduling

Time slot selection with availability checking

Automatic conflict resolution with alternative doctor suggestions

Patient registration with unique ID generation
```
#### Patient Management
```
New and returning patient identification

Dynamic pricing (€15 for new patients, €25 for returning)

Patient details form with validation

Medical notes encryption and storage
```

#### Consultation History & Status
```
Comprehensive consultation history viewer (DisplayTableForm)

Individual consultation status display (DisplayStatus)

Interactive table with row selection for detailed view

Complete consultation records with doctor and patient information
```
## Advanced Features
```
Image upload functionality for consultation records

Image encryption using DES algorithm

Consultation history tracking

Random doctor assignment for unavailable slots
```
## How to Run

### Requirements
```
Java JDK 8 or above

JCalendar library (for date picker functionality)

Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or command line
```
1. Compile the project:

```bash
javac -cp "lib/*:." src/ConsoleMenuImplementation/*.java src/GuiImplementation/*.java
```
2. Run the main program:

```bash
java -cp "lib/*:." ConsoleMenuImplementation.Main
```
3. Available menu options:
```
1 - Add a new doctor

2 - Delete a doctor

3 - Print list of doctors

4 - Save data to file

5 - Launch GUI interface

6 - Exit application
```
## GUI Mode

From the console menu, select option ```5``` to launch the graphical interface

The GUI automatically loads with the doctor management table

Access consultation history through the "View Consultations" feature

## Class Descriptions

### Core Classes (ConsoleMenuImplementation)

```Person```: Abstract base class with common attributes (name, surname, DOB, mobile)

```Doctor```: Extends Person, adds medical license and specialization

```Patient```: Extends Person, adds unique patient ID

```Consultation```: Manages consultation details, doctor assignment, and scheduling

```SkinConsultationManager```: Interface defining core management operations (AddDoctor, DeleteDoctor, PrintDoctors, SaveInFile)

```WestminsterSkinConsultationManager```: Main system controller implementing SkinConsultationManager interface

```Main```: Entry point for the console application

### GUI Classes (GuiImplementation)

```MainGUI```: Entry point for the graphical interface

```DoctorTable```: Main GUI window displaying doctor information and consultation booking

```PatientDetailsForm```: Form for patient registration and consultation details

```DisplayTableForm```: Consultation history viewer with interactive table and detailed information display

```DisplayStatus```: Individual consultation status display form

## Technical Features

### Data Management

ArrayList-based storage for runtime data management

File I/O operations for data persistence

Automatic data loading on application startup

Duplicate prevention through license number validation

Interface-based architecture for better code organization

### GUI Components

JTable with custom styling and selection handling

JDateChooser for intuitive date selection

JComboBox for time slot and patient selection

JFileChooser for image upload functionality

ListSelectionListener for interactive table row selection

Custom styling with colors and fonts (dark theme with gray background)

### Security Features

Image encryption using DES algorithm

Text encryption for sensitive consultation notes

Secure file storage for patient data

### User Interface Design

Consistent color scheme: Dark gray background (#696969) with white text

Professional typography: Tahoma font family with varying sizes

Interactive elements: Hover effects and selection highlighting

Responsive design: Fixed layouts optimized for different screen sections

Non-editable display fields for data integrity in consultation history

### File Output

The system generates several files:

```Doctor.txt``` - Raw doctor data for system reload

```Doctor_details.txt``` - Formatted doctor information for human reading

```Encrypted.jpg``` - Encrypted patient consultation images

### Navigation Flow

1. Console Application (Main.java) → WestminsterSkinConsultationManager

2. GUI Launch → MainGUI/DoctorTable

3. Patient Registration → PatientDetailsForm

4. Consultation History → DisplayTableForm

5. Individual Consultation View → DisplayStatus


## Dependencies

JCalendar - Date picker component

Java Swing - GUI framework

Java Crypto - Encryption functionality

Java I/O - File operations and data persistence

## Author
Sunethma Welathanthri

## License

This project is developed for educational purposes as part of university coursework.
