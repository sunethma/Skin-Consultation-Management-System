package GuiImplementation;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import ConsoleMenuImplementation.*;
public class DoctorTable {

    // initialize an arraylist to add all the consultation details.
    static ArrayList<Consultation> consultationArrayList = new ArrayList<>();

    // initialize an arraylist to add all the doctor details obtained form WestminsterSkinConsultationManager class.
    static ArrayList<Doctor> doctorArrayList = WestminsterSkinConsultationManager.doctorsList;

    public DoctorTable() {
        final JFrame j = new JFrame("Window");
        j.setTitle("Doctor Consultation");
        // pass the columns names into an object array.
        Object[] columns = new Object[]{"First Name", "Surname", "Date of Birth", "Mobile Number", "Medical License Number", "Specialization"};
        // create the necessary labels, buttons and text fields.
        final JTextField textFirstName = new JTextField();
        final JTextField surname = new JTextField();
        final JTextField dob = new JTextField();
        final JTextField mobileNo = new JTextField();
        final JTextField licenseNo = new JTextField();
        final JTextField specialization = new JTextField();
        JLabel lbFirstName = new JLabel("First Name");
        JLabel lbSurname = new JLabel("Surname");
        JLabel lbDob = new JLabel("Date of Birth");
        JLabel lbMobileNo = new JLabel("Mobile Number");
        JLabel lbLicenseNo = new JLabel("License Number");
        JLabel lbSpecialization = new JLabel("Specialization");
        JLabel date = new JLabel("Consultation date");
        JButton alphabeticalOrder = new JButton("in alphabetical order");
        JButton refresh = new JButton("refresh");
        JLabel time = new JLabel("Consultation time");
        final JDateChooser lbDate = new JDateChooser();
        String[] optionsToChoose = new String[]{"9.30am-10.30am", "10.30am-11.30am", "11.30am-12.30pm", "1.30pm-2.30pm", "2.30pm-3.30pm", "3.30pm-4.30pm", "4.30pm-5.30pm"};
        final JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        JButton addPatientDetails = new JButton("Add Patient Details");
        JButton checkAvailability = new JButton("Check Availability");
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        Border border1 = BorderFactory.createLineBorder(Color.black, 2);
        Border border2 = BorderFactory.createLineBorder(Color.black, 2);
        Border border3 = BorderFactory.createLineBorder(Color.black, 2);
        Border border4 = BorderFactory.createLineBorder(Color.black, 2);

        // to display the doctor details in a 2d manner(in a table format).
        final JTable table = new JTable();
        final DefaultTableModel model = new DefaultTableModel();
        j.getContentPane().setBackground(new Color(70,130,180));
        j.setBounds(200, 200, 1500, 1000);
        j.setDefaultCloseOperation(3);
        j.getContentPane().setLayout((LayoutManager) null);
        j.setLocationRelativeTo((Component) null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(new Color(255,255,255));
        //table.setForeground(Color.white);
        table.setSelectionBackground(new Color(204,229,255));
        table.setGridColor(Color.black);
        table.setFont(new Font("Tahoma", 1, 17));
        table.setRowHeight(45);
        table.setAutoCreateRowSorter(true);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.gray);
        header.setFont(new Font("Tahoma", 1, 18));
        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.red);
        pane.setBackground(Color.white);
        pane.setBounds(50, 20, 1400, 300);
        j.getContentPane().add(pane);

        // add the doctor details into the JTable rows.
        for (Doctor d : doctorArrayList) {
            Object[] row = {
                    d.getName(), d.getSurname(), d.getDob(), d.getMobileNo(), d.getLicenceNo(), d.getSpecialisation()
            };
            model.addRow(row);

        }
        // add the necessary font styles, colours to the labels and text-fields.
        textFirstName.setBounds(190, 600, 184, 35);
        textFirstName.setFont(new Font("Tahoma", 1, 18));
        j.getContentPane().add(textFirstName);
        textFirstName.setColumns(10);
        textFirstName.setBorder(border);
        lbFirstName.setFont(new Font("Tahoma", 0, 20));
        lbFirstName.setForeground(Color.black);
        lbFirstName.setBounds(50, 600, 184, 35);
        j.getContentPane().add(lbFirstName);
        surname.setBounds(190, 680, 184, 35);
        surname.setFont(new Font("Tahoma", 1, 18));
        j.getContentPane().add(surname);
        surname.setBorder(border1);
        surname.setColumns(10);
        lbSurname.setFont(new Font("Tahoma", 0, 20));
        lbSurname.setForeground(Color.black);
        lbSurname.setBounds(50, 680, 184, 35);
        j.getContentPane().add(lbSurname);
        dob.setBounds(760, 600, 184, 35);
        dob.setFont(new Font("Tahoma", 1, 18));
        j.getContentPane().add(dob);
        dob.setColumns(10);
        dob.setBorder(border);
        lbDob.setFont(new Font("Tahoma", 0, 20));
        lbDob.setForeground(Color.black);
        lbDob.setBounds(600, 600, 184, 35);
        j.getContentPane().add(lbDob);
        mobileNo.setBounds(760, 680, 184, 35);
        mobileNo.setFont(new Font("Tahoma", 1, 18));
        j.getContentPane().add(mobileNo);
        mobileNo.setColumns(10);
        mobileNo.setBorder(border3);
        lbMobileNo.setFont(new Font("Tahoma", 0, 20));
        lbMobileNo.setForeground(Color.black);
        lbMobileNo.setBounds(600, 680, 184, 35);
        j.getContentPane().add(lbMobileNo);
        licenseNo.setBounds(1260, 600, 184, 35);
        licenseNo.setFont(new Font("Tahoma", 1, 18));
        j.getContentPane().add(licenseNo);
        licenseNo.setColumns(10);
        licenseNo.setBorder(border);
        lbLicenseNo.setFont(new Font("Tahoma", 0, 20));
        lbLicenseNo.setForeground(Color.black);
        lbLicenseNo.setBounds(1080, 600, 184, 35);
        j.getContentPane().add(lbLicenseNo);
        specialization.setBounds(1260, 680, 184, 35);
        specialization.setFont(new Font("Tahoma", 1, 18));
        j.getContentPane().add(specialization);
        specialization.setColumns(10);
        specialization.setBorder(border3);
        lbSpecialization.setFont(new Font("Tahoma", 0, 20));
        lbSpecialization.setForeground(Color.black);
        lbSpecialization.setBounds(1080, 680, 184, 35);
        j.getContentPane().add(lbSpecialization);
        alphabeticalOrder.setFont(new Font("Tahoma", 1, 14));
        alphabeticalOrder.setBounds(1260, 540, 184, 35);
        j.getContentPane().add(alphabeticalOrder);
        alphabeticalOrder.setBackground(Color.white);
        alphabeticalOrder.setBorder(border);

        // this will order the doctors in alphabetical order according to surnames of the doctors.
        alphabeticalOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doctor doctor = new Doctor();
                String[][] array = new String[DoctorTable.doctorArrayList.size()][6];

                int y;
                for (y = 0; y < DoctorTable.doctorArrayList.size(); ++y) {
                    array[y][0] = ((Doctor) DoctorTable.doctorArrayList.get(y)).getName();
                    array[y][1] = ((Doctor) DoctorTable.doctorArrayList.get(y)).getSurname();
                    array[y][2] = ((Doctor) DoctorTable.doctorArrayList.get(y)).getDob();
                    array[y][3] = ((Doctor) DoctorTable.doctorArrayList.get(y)).getMobileNo();
                    array[y][4] = String.valueOf(((Doctor) DoctorTable.doctorArrayList.get(y)).getLicenceNo());
                    array[y][5] = ((Doctor) DoctorTable.doctorArrayList.get(y)).getSpecialisation();
                }

                DoctorTable.doctorArrayList.removeAll(DoctorTable.doctorArrayList);

                for (y = 0; y < array.length; ++y) {
                    for (int a = y + 1; a < array.length; ++a) {
                        if (array[y][1].compareTo(array[a][1]) > 0) {
                            String temp = array[y][1];
                            array[y][1] = array[a][1];
                            array[a][1] = temp;
                            String n1 = array[y][0];
                            array[y][0] = array[a][0];
                            array[a][0] = n1;
                            String n2 = array[y][2];
                            array[y][2] = array[a][2];
                            array[a][2] = n2;
                            String n3 = array[y][3];
                            array[y][3] = array[a][3];
                            array[a][3] = n3;
                            String n4 = array[y][4];
                            array[y][4] = array[a][4];
                            array[a][4] = n4;
                            String n5 = array[y][5];
                            array[y][5] = array[a][5];
                            array[a][5] = n5;
                        }
                    }
                }

                for (y = 0; y < array.length; ++y) {
                    doctor.setName(array[y][0]);
                    doctor.setSurname(array[y][1]);
                    doctor.setDob(array[y][2]);
                    doctor.setMobileNo(array[y][3]);
                    doctor.setLicencePlateNo(array[y][4]);
                    doctor.setSpecialisation(array[y][5]);
                    DoctorTable.doctorArrayList.add(new Doctor(doctor.getName(), doctor.getSurname(), doctor.getDob(), doctor.getMobileNo(), doctor.getLicenceNo(), doctor.getSpecialisation()));
                }

                for (y = 0; y < DoctorTable.doctorArrayList.size(); ++y) {
                    System.out.println(DoctorTable.doctorArrayList.get(y) + " ");
                }

                model.setRowCount(0);
                for (Doctor d : doctorArrayList) {
                    Object[] row = {
                            d.getName(), d.getSurname(), d.getDob(), d.getMobileNo(), d.getLicenceNo(), d.getSpecialisation()
                    };
                    model.addRow(row);

                }
            }

        });
        refresh.setFont(new Font("Tahoma", 1, 16));
        refresh.setBounds(1070, 540, 184, 35);
        j.getContentPane().add(refresh);
        refresh.setBackground(Color.white);
        refresh.setBorder(border);

        // this will refresh all the text-fields(make them empty).
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFirstName.setText(null);
                surname.setText(null);
                dob.setText(null);
                mobileNo.setText(null);
                licenseNo.setText(null);
                specialization.setText(null);
            }
        });
        date.setFont(new Font("Tahoma", 0, 18));
        date.setForeground(Color.black);
        date.setBounds(50, 740, 184, 35);
        j.getContentPane().add(date);
        lbDate.setBounds(190, 740, 184, 35);
        j.getContentPane().add(lbDate);
        lbDate.setBorder(border2);
        lbDate.setFont(new Font("Tamoha", 1, 17));
        time.setFont(new Font("Tahoma", 0, 19));
        time.setForeground(Color.black);
        time.setBounds(600, 740, 184, 35);
        j.getContentPane().add(time);
        jComboBox.setBounds(760, 740, 184, 35);
        j.getContentPane().add(jComboBox);
        addPatientDetails.setFont(new Font("Arial", 1, 18));
        jComboBox.setFont(new Font("Tamoha", 1, 17));
        j.getContentPane().add(addPatientDetails);
        jComboBox.setBorder(border4);
        addPatientDetails.setBounds(650, 850, 230, 40);
        addPatientDetails.setBackground(Color.white);
        addPatientDetails.setBorder(border);
        checkAvailability.setFont(new Font("Arial", 1, 18));
        checkAvailability.setBounds(900, 850, 230, 40);
        checkAvailability.setBackground(Color.white);
        checkAvailability.setBorder(border);
        j.getContentPane().add(checkAvailability);

        // this will check the availability of the doctor once a specific doctor is selected.
        checkAvailability.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Date date = lbDate.getDate();
                    String time = (String) jComboBox.getSelectedItem();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    formatter.format(date);
                    if (DoctorTable.consultationArrayList.size() != 0) {
                        for (Consultation c : consultationArrayList) {
                            boolean exists = DoctorTable.this.consultationExists(licenseNo.getText().trim(), date, time, c);
                            if (exists) {
                                JOptionPane.showMessageDialog((Component) null, "Sorry your request is denied, doctor " + textFirstName.getText() + " is currently" +
                                        " unavailable");
                                return;
                            }

                            JOptionPane.showMessageDialog((Component) null, "doctor is available, click 'ok' to proceed ");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component) null, "Doctor is available, click 'ok' to proceed");
                    }
                } catch (Exception var9) {
                    JOptionPane.showMessageDialog((Component) null, "please select date");
                }

            }
        });
        // this will add the data of the selected row in the table into the necessary text-fields.
        ListSelectionModel model1 = table.getSelectionModel();
        model1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedRowIndex = table.getSelectedRow();
                textFirstName.setText(((Doctor) DoctorTable.doctorArrayList.get(selectedRowIndex)).getName());
                surname.setText(((Doctor) DoctorTable.doctorArrayList.get(selectedRowIndex)).getSurname());
                dob.setText(((Doctor) DoctorTable.doctorArrayList.get(selectedRowIndex)).getDob());
                mobileNo.setText(((Doctor) DoctorTable.doctorArrayList.get(selectedRowIndex)).getMobileNo());
                licenseNo.setText(((Doctor) DoctorTable.doctorArrayList.get(selectedRowIndex)).getLicenceNo() + " ");
                specialization.setText(((Doctor) DoctorTable.doctorArrayList.get(selectedRowIndex)).getSpecialisation());

                // this will make the text-fields un-editable.
                textFirstName.setEditable(false);
                surname.setEditable(false);
                dob.setEditable(false);
                mobileNo.setEditable(false);
                licenseNo.setEditable(false);
                specialization.setEditable(false);
            }
        });
        // this button will navigate into a new window to obtain the patient details.
        addPatientDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Date date = lbDate.getDate();
                    String time = (String) jComboBox.getSelectedItem();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    formatter.format(date);
                    if (DoctorTable.consultationArrayList.size() != 0) {
                        for (Consultation c : consultationArrayList) {
                            boolean exists = DoctorTable.this.consultationExists(licenseNo.getText().trim(), date, time, c);
                            if (exists) {
                                Doctor doctor =randomDoctor(licenseNo.getText().trim(), date, time,specialization.getText().trim());
                                if(doctor==null){
                                    JOptionPane.showMessageDialog(null,"All doctors are busy");
                                    return;
                                }
                                PatientDetailsForm.doctor = doctor;
                                JOptionPane.showMessageDialog((Component) null, "doctor " + doctor.getName() + " is added instead.");
                                new PatientDetailsForm();
                                j.setDefaultCloseOperation(1);
                                return;
                            }

                            try {
                                PatientDetailsForm.date = lbDate.getDate();
                                PatientDetailsForm.time = (String) jComboBox.getItemAt(jComboBox.getSelectedIndex());
                                PatientDetailsForm.doctor = new Doctor(textFirstName.getText(), surname.getText(), dob.getText(), mobileNo.getText(), licenseNo.getText().trim(), specialization.getText());
                                new PatientDetailsForm();
                                j.setDefaultCloseOperation(1);
                            } catch (Exception var11) {
                                JOptionPane.showMessageDialog((Component) null, "Please enter all the details to proceed.");
                            }
                        }
                    } else {
                        try {
                            PatientDetailsForm.date = lbDate.getDate();
                            PatientDetailsForm.time = (String) jComboBox.getItemAt(jComboBox.getSelectedIndex());
                            PatientDetailsForm.doctor = new Doctor(textFirstName.getText(), surname.getText(), dob.getText(), mobileNo.getText(), licenseNo.getText().trim(), specialization.getText());
                            new PatientDetailsForm();
                            j.setDefaultCloseOperation(1);
                        } catch (Exception var10) {
                            JOptionPane.showMessageDialog((Component) null, "Enter correct input");
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,"please enter the date to proceed");
                }

            }
        });
        j.setResizable(true);
        j.setDefaultCloseOperation(2);
        j.setVisible(true);
    }

    // this will check whether the selected doctor is available for a consultation or not.
    public boolean consultationExists(String medicalNo, Date date, String time, Consultation consultation) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String consultationDate = formatter.format(consultation.getDate());
        String newDate = formatter.format(date);
        if (newDate.equalsIgnoreCase(consultationDate)) {
            if (Objects.equals(consultation.getDoctor().getLicenceNo(), medicalNo)) {
                return consultation.getTime().equalsIgnoreCase(time);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
 // if a specific doctor is not available for a consultation this will add a random doctor.

        public Doctor randomDoctor(String licenseNo, Date date, String time, String specialization) {
        Doctor doctor=null;
            ArrayList<Doctor> tempDoctors = new ArrayList<>();
            tempDoctors.addAll(doctorArrayList);
            /*for (Doctor d : tempDoctors) {
                System.out.println(d.getLicenceNo());
            }*/
            if (consultationArrayList.size() != 0) {
                for (Consultation consultation1 : consultationArrayList) {
                    boolean isBusy = consultationExists(licenseNo, date, time, consultation1);
                    if (isBusy) {

                        tempDoctors.remove(consultation1.getDoctor());

                    }
                }



            }
            ArrayList<Doctor> doctors=new ArrayList<>();
            for (Doctor d : tempDoctors) {
               // System.out.println(d.getLicenceNo());
                if (d.getSpecialisation().trim().equalsIgnoreCase(specialization)) {
                    doctors.add(d);
                    //System.out.println(d.getLicenceNo());
                }
            }
            if(doctors.size()==0)return null;
            Random random=new Random();
            return doctors.get(random.nextInt(doctors.size()));
        }
    }



