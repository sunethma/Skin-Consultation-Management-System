package ConsoleMenuImplementation;

import java.util.Date;
import GuiImplementation.*;

public class Consultation {

    // create the necessary attributes.
        private Doctor doctor;
        private Patient patient;
        private String cost;
        private String notes;
        private Date date;
        private String time;

        // create a constructor for the Consultation that will be used in the GUI part.
        public Consultation(Doctor doctor, Patient patient, String cost, String notes, Date date, String time) {
            this.doctor = doctor;
            this.patient = patient;
            this.cost = cost;
            this.notes = notes;
            this.date = date;
            this.time = time;
        }

     // this will be used in the Doctor class and the PatientDetailsForm in GUI section.
        public Consultation() {
        }

    // create constructor which is being called in the Doctor class.

        public Consultation(Date date, String time) {
        }
    // create the toString method in order to pass the string representation of the objects.
        public String toString() {
            return "Consultation{doctor=" + this.doctor + ", patient=" + this.patient + ", cost='" + this.cost + '\'' + ", notes='" + this.notes + '\'' + ", date=" + this.date + ", time='" + this.time + '\'' + '}';
        }

    // create the necessary getter and setter methods for retrieving and updating the variables outside the Consultation class.

        public Doctor getDoctor() {
            return this.doctor;
        }

        public void setDoctor(Doctor doctor) {
            this.doctor = doctor;
        }

        public Patient getPatient() {
            return this.patient;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
        }

        public String getCost() {
            return this.cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getNotes() {
            return this.notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public Date getDate() {
            return this.date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }



