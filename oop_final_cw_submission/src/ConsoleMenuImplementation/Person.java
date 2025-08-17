package ConsoleMenuImplementation;

import java.util.Scanner;

public class Person {

    // creates the necessary attributes.
    private String name = "";
    private String surname = "";
    private String dob = "";
    private String mobileNo = "";
    Scanner scanner;

    // creates the Person class constructor.


    public Person(String name, String surname, String dob, String mobileNo) {
        this.scanner = new Scanner(System.in);
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.mobileNo = mobileNo;
    }

    public Person() {
        this.scanner = new Scanner(System.in);
    }

    // this will be used in the Doctor class.

    public Person(String name, String surname) {
        this.scanner = new Scanner(System.in);
    }

    // create the necessary getter and setter methods for retrieving and updating the attributes outside the Person class.

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    // creates the DoctorDetails() method in order to obtain the necessary user inputs.
    public void DoctorDetails() {
        while(true) {
            System.out.print("please enter the name of the doctor: ");
            this.name = this.scanner.next();
            if (this.isAlpha(this.name)) {
                while(true) {
                    System.out.print("please enter the surname of the doctor: ");
                    this.surname = this.scanner.next();
                    if (this.isAlpha(this.surname)) {
                        System.out.print("please enter the date of birth of the doctor: ");
                        this.dob = this.scanner.next();
                        System.out.print("please enter the mobile number of the doctor: ");
                        this.mobileNo = this.scanner.next();
                        return;
                    }

                    System.out.println("please enter a valid input");
                }
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

