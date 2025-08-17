package ConsoleMenuImplementation;

import javax.swing.*;

public class Patient extends Person {

    // create the patient id attributes.
    private String patientId;

    // create the constructor of Patient class.
    public Patient(String name, String surname, String dob, String mobileNo, String patientId) {
        // call the super class(Person class) constructor.
        super(name, surname, dob, mobileNo);
        this.patientId = patientId;
    }
    // create the toString method in order to pass the string representation of the objects.
    public String toString() {
        return this.getName() + " " + this.getSurname() + " " + this.getDob() + " " + this.getMobileNo() + " " + this.getPatientId();
    }

    // create the getters and setters methods

    public String getPatientId() {
        return this.patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}

