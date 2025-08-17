package ConsoleMenuImplementation;

import java.util.Date;
import java.util.Scanner;

public class Doctor extends Person {
    Scanner scanner;
    // create the attributes medical license no and specialisation.
    private String MedicalLicenceNo;
    private String specialisation;
 // create a doctor constructor by passing name,surname,dob,mobileNo,licenseNo and specialization.
    public Doctor(String name, String surname, String dob, String mobileNo, String medicalLicenceNo, String specialisation) {
        //call the constructor in the parent class(Person class)
        super(name, surname, dob, mobileNo);
        this.scanner = new Scanner(System.in);
        this.MedicalLicenceNo = medicalLicenceNo;
        this.specialisation = specialisation;
    }
 // create a doctor constructor, this will be used in the GUI part.
    public Doctor(String name, String surname, String licencePlateNo, Date date, String time) {
        //call the constructor in the parent class(Person class)
        super(name, surname);
        this.scanner = new Scanner(System.in);
        // call the constructor in the Consultation class.
        new Consultation(date, time);
        this.MedicalLicenceNo = licencePlateNo;
        this.specialisation = this.specialisation;
    }

    public Doctor() {
        this.scanner = new Scanner(System.in);
    }
   // create the toString method in order to pass the string representation of the objects.
    public String toString() {
        return this.getName() + " " + this.getSurname() + " " + this.getDob() + " " + this.getMobileNo() + " " + this.getLicenceNo() + " " + this.getSpecialisation();
    }

    // create the necessary getter and setter methods for retrieving and updating the variables outside the Doctor class.
    public String getLicenceNo() {
        return this.MedicalLicenceNo;
    }

    public void setLicencePlateNo(String licencePlateNo) {
        this.MedicalLicenceNo = licencePlateNo;
    }

    public String getSpecialisation() {
        return this.specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

 /*   public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Doctor)) {
            return false;
        } else {
            Doctor doctor = (Doctor)o;
            return Objects.equals(this.MedicalLicenceNo, doctor.MedicalLicenceNo);
        }
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return MedicalLicenceNo.equals(doctor.MedicalLicenceNo) && specialisation.equals(doctor.specialisation);
    }



    // create LicensePLateNo() method to obtain the user inputs.
    public void LicencePlateNo() {

        System.out.print("please enter the doctor's license plate number: ");
        Scanner scanner1 = new Scanner(System.in);
        this.MedicalLicenceNo = scanner1.next();
    }

    // create Specialisation() class to obtain the user inputs.

    public void Specialisation() {
        while(true) {
            System.out.print("please enter the doctor's specialisation: ");
            this.specialisation = this.scanner.next();
            if (this.isAlpha(this.specialisation)) {
                return;
            }

            System.out.println("please enter a valid input");
        }
    }
  // to check whether the user inputs valid inputs.
    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        char[] var3 = chars;
        int var4 = chars.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char c = var3[var5];
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}
