package GuiImplementation;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Stream;

import ConsoleMenuImplementation.*;

public class PatientDetailsForm extends JFrame {

    // create the necessary attributes
     static Doctor doctor;
    static Date date;
    static String time;
    static String id;
    String fname;
    String surname;
    String dob;
    Image image;

    // initialize an arraylist for patients in order to obtain patient details.
    static ArrayList<Patient> patientArrayList = new ArrayList<>();
    String selectedImagePath;

    public PatientDetailsForm() {
        this.setDefaultCloseOperation(2);
        this.getContentPane().setBackground(new Color(112,128,144));
        this.setBounds(200, 200, 1100, 800);
        this.getContentPane().setLayout((LayoutManager)null);
        this.setLocationRelativeTo((Component)null);
        this.setTitle("Consultation");
        this.setResizable(true);

        // create the necessary labels, buttons and text-fields.
        JLabel lbSelectPatient = new JLabel("Select Patient");
        lbSelectPatient.setFont(new Font("Tahoma", 1, 18));
        lbSelectPatient.setForeground(Color.black);
        lbSelectPatient.setBounds(5, 20, 184, 20);
        this.getContentPane().add(lbSelectPatient);
        final JTextField patientId = new JTextField();
        patientId.setBounds(200, 100, 184, 35);
        patientId.setFont(new Font("Tamoha", 1, 18));
        patientId.setBackground(Color.white);
        this.getContentPane().add(patientId);
        JLabel lblPatientId = new JLabel("Patient Id");
        lblPatientId.setFont(new Font("Tahoma", 1, 18));
        lblPatientId.setForeground(Color.black);
        lblPatientId.setBounds(5, 100, 184, 20);
        this.getContentPane().add(lblPatientId);
        final JTextField patientName = new JTextField();
        patientId.setEditable(false);
        patientId.setText(getPatientId());
        patientName.setBounds(200, 200, 184, 35);
        patientName.setFont(new Font("Tamoha", 1, 18));
        patientName.setBackground(Color.white);
        this.getContentPane().add(patientName);
        JLabel lblPatientName = new JLabel("Patient Name");
        lblPatientName.setFont(new Font("Tahoma", 1, 18));
        lblPatientName.setForeground(Color.black);
        lblPatientName.setBounds(5, 200, 184, 20);
        this.getContentPane().add(lblPatientName);
        final JTextField patientSurName = new JTextField();
        patientSurName.setBounds(200, 300, 184, 35);
        patientSurName.setFont(new Font("Tamoha", 1, 18));
        patientSurName.setBackground(Color.white);
        this.getContentPane().add(patientSurName);
        JLabel lblPatientSurName = new JLabel("Patient Surname");
        lblPatientSurName.setFont(new Font("Tahoma", 1, 18));
        lblPatientSurName.setForeground(Color.black);
        lblPatientSurName.setBounds(5, 300, 184, 20);
        this.getContentPane().add(lblPatientSurName);
        final JTextField patientDob = new JTextField();
        patientDob.setBounds(200, 400, 184, 35);
        patientDob.setFont(new Font("Tamoha", 1, 18));
        patientDob.setBackground(Color.white);
        this.getContentPane().add(patientDob);
        JLabel lblPatientDob = new JLabel("Patient DoB");
        lblPatientDob.setFont(new Font("Tahoma", 1, 18));
        lblPatientDob.setForeground(Color.black);
        lblPatientDob.setBounds(5, 400, 184, 20);
        this.getContentPane().add(lblPatientDob);
        final JTextField patientMobileNo = new JTextField();
        patientMobileNo.setBounds(200, 500, 184, 35);
        patientMobileNo.setFont(new Font("Tamoha", 1, 18));
        patientMobileNo.setBackground(Color.white);
        this.getContentPane().add(patientMobileNo);
        JLabel lblPatientMobileNo = new JLabel("Patient Mobile No");
        lblPatientMobileNo.setFont(new Font("Tahoma", 1, 18));
        lblPatientMobileNo.setForeground(Color.black);
        lblPatientMobileNo.setBounds(5, 500, 184, 20);
        this.getContentPane().add(lblPatientMobileNo);
        final JTextField cost = new JTextField();
        cost.setBounds(200, 600, 184, 35);
        cost.setFont(new Font("Tamoha", 1, 18));
        cost.setBackground(Color.white);
        this.getContentPane().add(cost);
        JButton button = new JButton("Add Cost");
        button.setFont(new Font("Arial", 1, 18));
        button.setBounds(5, 600, 160, 35);
        button.setBackground(Color.WHITE);
        this.getContentPane().add(button);

        // this will check whether the added patient is a new patient or a old patient and add the cost accordingly.
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cost.setText("Euro15");
                if (DoctorTable.consultationArrayList.size() == 0) {
                    cost.setText("Euro15");
                } else {
                    //System.out.println(patientId.getText());

                    for(int i = 0; i < DoctorTable.consultationArrayList.size(); ++i) {
                        if (patientId.getText().equals(String.valueOf(((Consultation) DoctorTable.consultationArrayList.get(i)).getPatient().getPatientId()))) {
                            cost.setText("Euro25");
                            break;
                        }
                    }

                   // System.out.println(cost.getText());
                }

            }
        });
        JButton refresh =new JButton("Refresh");
        refresh.setFont(new Font("Arial", 1, 18));
        refresh.setBounds(210, 680, 160, 35);
        refresh.setBackground(Color.WHITE);
        this.getContentPane().add(refresh);

        // this will refresh all the fields if the user needs
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientName.setText(null);
                patientSurName.setText(null);
                patientDob.setText(null);
                patientMobileNo.setText(null);
                cost.setText(null);
                patientId.setText(getPatientId());
                patientName.setEditable(true);
                patientSurName.setEditable(true);
                patientDob.setEditable(true);
                patientMobileNo.setEditable(true);


            }
        });
        final JTextArea Notes = new JTextArea();
        Notes.setBounds(500, 350, 200, 100);
        Notes.setFont(new Font("Tamoha", 1, 18));
        Notes.setBackground(Color.white);
        this.getContentPane().add(Notes);
        JLabel insertNote = new JLabel("Add note");
        insertNote.setBounds(550, 470, 200, 30);
        insertNote.setFont(new Font("Tahoma", 1, 18));
        insertNote.setForeground(Color.BLACK);
        this.getContentPane().add(insertNote);
        final JLabel AddImage = new JLabel();
        AddImage.setFont(new Font("Tahoma", 1, 18));
        AddImage.setForeground(Color.BLACK);
        AddImage.setBounds(470, 100, 300, 200);
        this.getContentPane().add(AddImage);
        JButton back = new JButton("Back");
        back.setFont(new Font("Tahoma", 1, 17));
        back.setForeground(Color.black);
        back.setBackground(Color.WHITE);
        back.setBounds(800, 400, 200, 30);
        this.getContentPane().add(back);

        // this will navigate to the previous window.
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientDetailsForm.this.setVisible(false);
            }
        });
        JButton uploadImage = new JButton("Upload");
        uploadImage.setFont(new Font("Tahoma", 1, 17));
        uploadImage.setForeground(Color.black);
        uploadImage.setBackground(Color.WHITE);
        uploadImage.setBounds(500, 305, 200, 30);
        this.getContentPane().add(uploadImage);

        //his will allow the user to upload images of the skin when the consultation is done.
        uploadImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser browseImageFile = new JFileChooser();
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("Images", "png", "jpg", "jpeg");
                browseImageFile.addChoosableFileFilter(fnef);
                int showOpenDialogue = browseImageFile.showOpenDialog((Component)null);
                if (showOpenDialogue == 0) {
                    File selectedImageFile = browseImageFile.getSelectedFile();
                    PatientDetailsForm.this.selectedImagePath = selectedImageFile.getAbsolutePath();
                    JOptionPane.showMessageDialog((Component)null, PatientDetailsForm.this.selectedImagePath);
                    ImageIcon icon = new ImageIcon(PatientDetailsForm.this.selectedImagePath);
                     image = icon.getImage().getScaledInstance(AddImage.getWidth(), AddImage.getHeight(), 4);
                    AddImage.setIcon(new ImageIcon(image));
                    System.out.println(image);

                    //this will encrypt the image and add it to a file named "Encrypted image".

                    try {
                        FileInputStream file = new FileInputStream(PatientDetailsForm.this.selectedImagePath);
                        FileOutputStream outStream = new FileOutputStream("Encrypted.jpg");
                        byte[] k = "NiTh5252".getBytes();
                        SecretKeySpec keySpec = new SecretKeySpec(k, "DES");
                        Cipher cipher = Cipher.getInstance("DES");
                        cipher.init(1, keySpec);
                        CipherOutputStream cipherOutputStream = new CipherOutputStream(outStream, cipher);
                        byte[] buf = new byte[1024];

                        int read;
                        while((read = file.read(buf)) != -1) {
                            cipherOutputStream.write(buf, 0, read);
                        }

                        file.close();
                        outStream.flush();
                        cipherOutputStream.close();
                        JOptionPane.showMessageDialog((Component)null, "Image encrypted successfully");
                    } catch (Exception var16) {
                        JOptionPane.showMessageDialog((Component)null, var16);
                    }
                }

            }
        });


        JButton consultation = new JButton("Add Consultation");
        consultation.setFont(new Font("Tahoma", 1, 17));
        consultation.setForeground(Color.black);
        consultation.setBackground(Color.WHITE);
        consultation.setBounds(800, 300, 200, 30);
        this.getContentPane().add(consultation);

        // this will add the consultation to the system.
        consultation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent s) {
                Doctor doctor1 = new Doctor();

                while(true) {
                    PatientDetailsForm.this.fname = patientName.getText();
                    if (doctor1.isAlpha(PatientDetailsForm.this.fname)) {
                        while(true) {
                            PatientDetailsForm.this.surname = patientSurName.getText();
                            if (doctor1.isAlpha(PatientDetailsForm.this.surname)) {
                                String dob = patientDob.getText();
                                String mobileNo = patientMobileNo.getText();
                                PatientDetailsForm.id = patientId.getText();
                                String note = Notes.getText();
                                if (note.isEmpty() && PatientDetailsForm.this.image == null) {
                                    note = "Not added.";
                                } else if (note.isEmpty()) {
                                    note = PatientDetailsForm.this.image.toString();
                                } else{
                                int key = 6;
                                    char[] chars = note.toCharArray();

                                    for(int x = 0; x < chars.length; ++x) {
                                        chars[x] = (char)(chars[x] + key);
                                    }

                                    note = (String)Stream.of(chars).map(String::new).reduce((acc, e) -> {
                                        return acc + e;
                                    }).get();
                                }


                                if (PatientDetailsForm.id.trim().equalsIgnoreCase("")) {
                                    return;
                                } else {
                                    new Consultation();
                                    if (!patientName.getText().isEmpty() && !patientSurName.getText().isEmpty() && !patientDob.getText().isEmpty() && !patientMobileNo.getText().isEmpty() && !cost.getText().isEmpty()) {
                                        System.out.println(patientName.getText());
                                        Patient patient = new Patient(PatientDetailsForm.this.fname, PatientDetailsForm.this.surname, dob, patientMobileNo.getText(), PatientDetailsForm.id);
                                        Consultation consultation2 = new Consultation(PatientDetailsForm.doctor, patient, cost.getText(), note, PatientDetailsForm.date, PatientDetailsForm.time);
                                        if (!PatientDetailsForm.this.isDuplicate(patient)) {
                                            PatientDetailsForm.patientArrayList.add(patient);
                                        }

                                        DoctorTable.consultationArrayList.add(consultation2);
                                    } else {
                                        JOptionPane.showMessageDialog((Component)null, "please enter all the details properly");
                                    }

                                    return;
                                }
                            }

                            JOptionPane.showMessageDialog((Component)null, "please enter the surname properly");
                            patientSurName.setText((String)null);
                        }
                    }

                    JOptionPane.showMessageDialog((Component)null, "please enter the name properly");
                    patientName.setText((String)null);
                }
            }
        });
        String[] tempArray = new String[patientArrayList.size()];

        for(int i = 0; i < tempArray.length; ++i) {
            String data = ((Patient)patientArrayList.get(i)).getPatientId() + " " + ((Patient)patientArrayList.get(i)).getName() + " " + ((Patient)patientArrayList.get(i)).getSurname();
            tempArray[i] = data;
        }

        final JComboBox<String> comboBox = new JComboBox<>(tempArray);
        // if the patient is selected from the combo box the necessary patient details will be added to text-fields.
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = comboBox.getSelectedIndex();
                patientId.setText(((Patient)PatientDetailsForm.patientArrayList.get(index)).getPatientId());
                patientName.setText(((Patient)PatientDetailsForm.patientArrayList.get(index)).getName());
                patientSurName.setText(((Patient)PatientDetailsForm.patientArrayList.get(index)).getSurname());
                patientDob.setText(((Patient)PatientDetailsForm.patientArrayList.get(index)).getDob());
                patientMobileNo.setText(((Patient)PatientDetailsForm.patientArrayList.get(index)).getMobileNo());

                // this will make the text-fields un-editable.
                patientName.setEditable(false);
                patientSurName.setEditable(false);
                patientDob.setEditable(false);
                patientMobileNo.setEditable(false);
            }
        });
        comboBox.setBounds(200, 10, 400, 35);
        comboBox.setFont(new Font("eyreuer", 1, 18));
        this.getContentPane().add(comboBox);
        JButton viewStatus = new JButton("View Consultation");
        viewStatus.setFont(new Font("Tahoma", 1, 17));
        viewStatus.setForeground(Color.black);
        viewStatus.setBackground(Color.WHITE);
        viewStatus.setBounds(800, 350, 200, 30);
        this.getContentPane().add(viewStatus);

        // this will navigate to a new window containing the status of the added consultation.
        viewStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DisplayTableForm();
                PatientDetailsForm.this.setVisible(false);
            }
        });
        this.setVisible(true);
    }

    // this will check if the user is going to add a previous patient again to the system.

    public boolean isDuplicate(Patient patient) {
        Iterator var2 = patientArrayList.iterator();

        Patient p;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            p = (Patient)var2.next();
        } while(!patient.getPatientId().equalsIgnoreCase(p.getPatientId()));

        return true;
    }

    // this will auto-generate an id for the newly added patients.
    public static String getPatientId() {
        int length = patientArrayList.size();
        return String.format("%04d", length + 1);
    }

}

             // reference
             // https://1bestcsharp.blogspot.com/2015/04/java-how-to-browse-image-file-and-And-Display-It-Using-JFileChooser-In-Java.html

            // https://www.geeksforgeeks.org/encrypt-and-decrypt-image-using-java/