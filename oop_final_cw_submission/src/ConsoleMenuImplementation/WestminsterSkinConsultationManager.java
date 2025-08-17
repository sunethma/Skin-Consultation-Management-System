package ConsoleMenuImplementation;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import GuiImplementation.*;
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    // initialize an arraylist in order to add all the doctor details.
    public static ArrayList<Doctor> doctorsList = new ArrayList<>();
    Doctor p = new Doctor();
    Scanner scanner;

    // creates the constructor for the class.
    public WestminsterSkinConsultationManager() throws IOException, ParseException {
        this.scanner = new Scanner(System.in);

        // loads back the data that is previously saved in the file.
        File tmpDir = new File("Doctor.txt");
        boolean exists = tmpDir.exists();
        if (exists) {
            List<String> listOfStrings = new ArrayList<>();
            BufferedReader bf = new BufferedReader(new FileReader("Doctor.txt"));

            for (String line = bf.readLine(); line != null; line = bf.readLine()) {
                listOfStrings.add(line);
            }

            bf.close();
            String[] array = (String[]) listOfStrings.toArray(new String[0]);
            int c = 0;
            ArrayList<String> a = new ArrayList<>();

            int i;
            for (i = 0; i < array.length; ++i) {
                a.add(array[c++]);
            }

            /*for (i = 0; i < a.size(); ++i) {
                System.out.println((String) a.get(i) + ", ");
            }
*/
            i = 0;

            while (i < a.size()) {
                this.p.setName((String) a.get(i++));
                this.p.setSurname((String) a.get(i++));
                this.p.setDob((String) a.get(i++));
                this.p.setMobileNo((String) a.get(i++));
                this.p.setLicencePlateNo((String) a.get(i++));
                this.p.setSpecialisation((String) a.get(i++));
                doctorsList.add(new Doctor(this.p.getName(), this.p.getSurname(), this.p.getDob(), this.p.getMobileNo(), this.p.getLicenceNo(), this.p.getSpecialisation()));
            }
        }

       /* for (int j = 0; j < doctorsList.size(); j++) {
            System.out.println(((Doctor) doctorsList.get(j)).getName() + ", " + ((Doctor) doctorsList.get(j)).getSurname() + ", " + ((Doctor) doctorsList.get(j)).getDob() + ", " + ((Doctor) doctorsList.get(j)).getMobileNo() + ", " + ((Doctor) doctorsList.get(j)).getLicenceNo() + ", " + ((Doctor) doctorsList.get(j)).getSpecialisation());
        }*/


        // option menu to select options.

        System.out.println("------------------------------------------Welcome to Westminster skin care consultation Manager----------------------------------------\n");

            int option = 0;
            inner:
            while (true) {
                System.out.println("Select one of the following options, you can enter the numerical value in front of the selected option: \n " +
                        "1). Add a doctor. \n 2). Delete a doctor. \n 3). Print the list of doctors. \n 4). Save in a file. \n 5). GUI. \n 6) To exit.");
                try {
                     option = this.scanner.nextInt();


                    switch (option) {
                        case 1:
                            this.AddDoctor(doctorsList);
                            break;
                        case 2:
                            this.DeleteDoctor(doctorsList);
                            break;
                        case 3:
                            this.PrintDoctors(doctorsList);
                            break;
                        case 4:
                            this.SaveInFile(doctorsList);
                            break;
                        case 5:
                            new MainGUI();
                            break;
                        case 6:
                            break inner ;
                        default:
                            System.out.println("please enter a valid option and try again.\n");

                    }


                } catch (Exception e) {
                    System.out.println("pls enter a valid input and try again.\n");
                    this.scanner.next();

                }


            }
    }

    // create method "AddDoctor" to add doctors in to system.
    public void AddDoctor(ArrayList<Doctor> doctorsList) {
        int noOfDoctors = doctorsList.size();

        String licenseNo;
        for(String option = "Y"; option.equals("Y"); option = option.toUpperCase()) {
            if (noOfDoctors >= 10) {
                System.out.println("Already 10 doctors are entered to the system.");
                break;
            }

            this.p.LicencePlateNo();
            licenseNo = this.CheckRepeat(doctorsList, this.p.getLicenceNo());
            if (licenseNo == null) {
                break;
            }

            this.p.DoctorDetails();
            this.p.Specialisation();
            doctorsList.add(new Doctor(this.p.getName(), this.p.getSurname(), this.p.getDob(), this.p.getMobileNo(), this.p.getLicenceNo(), this.p.getSpecialisation()));
            ++noOfDoctors;
            //System.out.println(noOfDoctors);
            System.out.println("Doctor added successfully. Do you want to add another doctor(Y/N).");
            option = this.scanner.next();
        }

       /* for (int j = 0; j < doctorsList.size(); j++) {
            System.out.println(doctorsList.get(j).getName() + ", " + doctorsList.get(j).getSurname() + ", " + doctorsList.get(j).getDob() + ", " + doctorsList.get(j).getMobileNo() + ", " + doctorsList.get(j).getLicenceNo() + ", " + doctorsList.get(j).getSpecialisation());

        }
*/
    }

    // this will check if the doctor added by the user is already in the system or not.

    public String CheckRepeat(ArrayList<Doctor> doctor, String licenseNo) {
        String option = "Y";

        for(int x = 0; x < doctorsList.size(); ++x) {
            if (Objects.equals(((Doctor)doctorsList.get(x)).getLicenceNo(), licenseNo)) {
                System.out.println("This doctor is already added to the system. Do you want to add another doctor(Y/N).");
                option = this.scanner.next();
                option = option.toUpperCase();
                if (!option.equals("Y")) {
                    licenseNo = null;
                    return licenseNo;
                }

                this.p.LicencePlateNo();
                licenseNo = this.p.getLicenceNo();
                x = -1;
            }
        }

        return licenseNo;
    }
    // create method "DeleteDoctor" to delete doctors from the system.

    public void DeleteDoctor(ArrayList<Doctor> doctor) {
        String option = "Y";

        int j;
        label56:
        while(true) {
            this.p.LicencePlateNo();
          // checks if the user entered license number is in the system or not.
            for(j = 0; j < doctorsList.size(); ++j) {
                if (Objects.equals(((Doctor)doctorsList.get(j)).getLicenceNo(), this.p.getLicenceNo())) {

                    // prints the deleted doctor details in the console.
                    System.out.println(" Doctor's name: " + ((Doctor)doctorsList.get(j)).getName() + " " + ((Doctor)doctorsList.get(j)).getSurname() +
                            " \n date of birth: " + ((Doctor)doctorsList.get(j)).getDob() + " \n mobile number: " +
                            ((Doctor)doctorsList.get(j)).getMobileNo() + " \n medical license plate number: " +
                            ((Doctor)doctorsList.get(j)).getLicenceNo() + " \n specialised in: " +
                            ((Doctor)doctorsList.get(j)).getSpecialisation() + " \ndeleted successfully.");

                    // will delete the doctor
                    doctorsList.remove(j);


                    int noOfDoctors;
                    /*for(noOfDoctors = 0; noOfDoctors < doctorsList.size(); ++noOfDoctors) {
                        System.out.println(((Doctor)doctorsList.get(noOfDoctors)).getName() + ", " + ((Doctor)doctorsList.get(noOfDoctors)).getSurname() + ", " + ((Doctor)doctorsList.get(noOfDoctors)).getDob() + ", " + ((Doctor)doctorsList.get(noOfDoctors)).getMobileNo() + ", " + ((Doctor)doctorsList.get(noOfDoctors)).getLicenceNo() + ", " + ((Doctor)doctorsList.get(noOfDoctors)).getSpecialisation());
                    }*/

                    noOfDoctors = 0;

                    for(int i = 0; i < doctorsList.size(); ++i) {
                        ++noOfDoctors;
                    }

                    System.out.println("Total number of doctors in the system is: " + noOfDoctors);
                    System.out.println("Do you want to delete another doctor from the system(Y/N): ");
                    option = this.scanner.next();
                    option = option.toUpperCase();
                    if (option.equals("Y")) {
                        continue label56;
                    }

                    if (option.equals("N")) {
                        break label56;
                    }
                }
            }

            System.out.println("There is no doctor with the medical license number you entered. Would you like to enter another license number(Y/N).");
            option = this.scanner.next();
            option = option.toUpperCase();
            if (option.equals("N")) {
                break;
            }
        }

       /* for(j = 0; j < doctorsList.size(); ++j) {
            System.out.println(((Doctor)doctorsList.get(j)).getName() + ", " + ((Doctor)doctorsList.get(j)).getSurname() + ", " + ((Doctor)doctorsList.get(j)).getDob() + ", " + ((Doctor)doctorsList.get(j)).getMobileNo() + ", " + ((Doctor)doctorsList.get(j)).getLicenceNo() + ", " + ((Doctor)doctorsList.get(j)).getSpecialisation());
        }*/

    }

    // create method "PrintDoctors" to print the list of doctors in the system in alphabetical order according to the surnames.
    public void PrintDoctors(ArrayList<Doctor> doctorsList) {
        String[][] array = new String[doctorsList.size()][6];

        int count;
        for(count = 0; count < doctorsList.size(); ++count) {
            array[count][0] = ((Doctor)doctorsList.get(count)).getName();
            array[count][1] = String.valueOf(((Doctor)doctorsList.get(count)).getSurname());
            array[count][2] = ((Doctor)doctorsList.get(count)).getDob();
            array[count][3] = ((Doctor)doctorsList.get(count)).getMobileNo();
            array[count][4] = String.valueOf(((Doctor)doctorsList.get(count)).getLicenceNo());
            array[count][5] = ((Doctor)doctorsList.get(count)).getSpecialisation();
        }

        doctorsList.removeAll(doctorsList);

        int b;
        for(count = 0; count < array.length; ++count) {
            for(b = count + 1; b < array.length; ++b) {
                if (array[count][1].compareTo(array[b][1]) > 0) {
                    String temp = array[count][1];
                    array[count][1] = array[b][1];
                    array[b][1] = temp;
                    String n1 = array[count][0];
                    array[count][0] = array[b][0];
                    array[b][0] = n1;
                    String n2 = array[count][2];
                    array[count][2] = array[b][2];
                    array[b][2] = n2;
                    String n3 = array[count][3];
                    array[count][3] = array[b][3];
                    array[b][3] = n3;
                    String n4 = array[count][4];
                    array[count][4] = array[b][4];
                    array[b][4] = n4;
                    String n5 = array[count][5];
                    array[count][5] = array[b][5];
                    array[b][5] = n5;
                }
            }
        }

        for(count = 0; count < array.length; ++count) {
            this.p.setName(array[count][0]);
            this.p.setSurname(array[count][1]);
            this.p.setDob(array[count][2]);
            this.p.setMobileNo(array[count][3]);
            this.p.setLicencePlateNo(array[count][4]);
            this.p.setSpecialisation(array[count][5]);
            doctorsList.add(new Doctor(this.p.getName(), this.p.getSurname(), this.p.getDob(), this.p.getMobileNo(), this.p.getLicenceNo(), this.p.getSpecialisation()));
        }

        /*for(count = 0; count < doctorsList.size(); ++count) {
            System.out.println(((Doctor)doctorsList.get(count)).getName() + ", " + ((Doctor)doctorsList.get(count)).getSurname() + ", " + ((Doctor)doctorsList.get(count)).getDob() + ", " + ((Doctor)doctorsList.get(count)).getMobileNo() + ", " + ((Doctor)doctorsList.get(count)).getLicenceNo() + ", " + ((Doctor)doctorsList.get(count)).getSpecialisation());
        }*/

        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------%n");
        System.out.println("|                                                 DOCTOR'S DETAILS                                              |");
        System.out.printf("----------------------------------------------------------------------------------------------------------------------------%n%n");
        System.out.printf("----------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("    |    %-6s   | %-15s  | %-12s   | %-15s  | %-25s  | %-15s  | %n", "Name", "Surname", "Dob", "Mobile number", "Medical license number", "Specialisation");
        System.out.printf("----------------------------------------------------------------------------------------------------------------------------%n");
        count = 0;

        for(b = 0; b < doctorsList.size(); ++b) {
            ++count;
            System.out.printf("| %-2s|  %-10s | %-16s | %-13s  | %-15s  | %-25s  | %-15s  | %n", count, ((Doctor)doctorsList.get(b)).getName(), ((Doctor)doctorsList.get(b)).getSurname(), ((Doctor)doctorsList.get(b)).getDob(), ((Doctor)doctorsList.get(b)).getMobileNo(), ((Doctor)doctorsList.get(b)).getLicenceNo(), ((Doctor)doctorsList.get(b)).getSpecialisation());
        }

        System.out.printf("----------------------------------------------------------------------------------------------------------------------------%n");
    }

    // create method "SaveInFile" in order to save the doctors into a file.

    public void SaveInFile(ArrayList<Doctor> doctorsList) throws IOException {
        System.out.println("DOCTOR'S DETAILS\n");

        FileWriter data1;
        int i;
        try {
            data1 = new FileWriter("Doctor_details.txt");

            for(i = 0; i < doctorsList.size(); ++i) {
                data1.write("Doctor's name:" + ((Doctor)doctorsList.get(i)).getName() + "\n");
                data1.write("Doctor's surname:" + ((Doctor)doctorsList.get(i)).getSurname() + "\n");
                data1.write("Doctor's date of Birth:" + ((Doctor)doctorsList.get(i)).getDob() + "\n");
                data1.write("Doctor's mobile no:" + ((Doctor)doctorsList.get(i)).getMobileNo() + "\n");
                data1.write("Doctor's license no:" + ((Doctor)doctorsList.get(i)).getLicenceNo() + "\n");
                data1.write("Doctor's specialisation:" + ((Doctor)doctorsList.get(i)).getSpecialisation() + "\n\n");
            }

            data1.close();
            System.out.println("The file was successfully written to..");
        } catch (IOException var5) {
            System.out.println("There was a mistake.");
            var5.printStackTrace();
        }

        try {
            data1 = new FileWriter("Doctor.txt");

            for(i = 0; i < doctorsList.size(); ++i) {
                data1.write(((Doctor)doctorsList.get(i)).getName() + "\n");
                data1.write(((Doctor)doctorsList.get(i)).getSurname() + "\n");
                data1.write(((Doctor)doctorsList.get(i)).getDob() + "\n");
                data1.write(((Doctor)doctorsList.get(i)).getMobileNo() + "\n");
                data1.write(((Doctor)doctorsList.get(i)).getLicenceNo() + "\n");
                data1.write(((Doctor)doctorsList.get(i)).getSpecialisation() + "\n");
            }

            data1.close();
            System.out.println("The file was successfully written to..");
        } catch (IOException var4) {
            System.out.println("There was a mistake.");
            var4.printStackTrace();
        }

    }
}
                       // reference
                       //Java Create and Write To Files.
                     // https://www.w3schools.com/java/java_files_create.asp.