package GuiImplementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayStatus extends JFrame {
    public DisplayStatus() {
        this.setTitle("View status");
        this.getContentPane().setBackground(new Color(105,105,105));
        this.setBounds(200, 200, 1130, 950);
        this.getContentPane().setLayout((LayoutManager)null);
        this.setLocationRelativeTo((Component)null);
        // create the relevant labels, buttons and text-fields in order to the get the user input data.
        JLabel print = new JLabel("Doctor's Details ");
        print.setFont(new Font("Tahoma", 0, 25));
        print.setForeground(Color.white);
        print.setBounds(20, 30, 184, 20);
        this.getContentPane().add(print);
        JTextField textFirstName = new JTextField();
        textFirstName.setBounds(190, 100, 184, 35);
        textFirstName.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(textFirstName);
        textFirstName.setColumns(10);
        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setFont(new Font("Tahoma", 0, 20));
        lbFirstName.setForeground(Color.white);
        lbFirstName.setBounds(20, 100, 184, 35);
        this.getContentPane().add(lbFirstName);
        JTextField surname = new JTextField();
        surname.setBounds(190, 200, 184, 35);
        surname.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(surname);
        surname.setColumns(10);
        JLabel lbSurname = new JLabel("Surname");
        lbSurname.setFont(new Font("Tahoma", 0, 20));
        lbSurname.setForeground(Color.white);
        lbSurname.setBounds(20, 200, 184, 35);
        this.getContentPane().add(lbSurname);
        JTextField licenseNo = new JTextField();
        licenseNo.setBounds(190, 300, 184, 35);
        licenseNo.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(licenseNo);
        licenseNo.setColumns(10);
        JLabel lbLicenseNo = new JLabel("License Number");
        lbLicenseNo.setFont(new Font("Tahoma", 0, 20));
        lbLicenseNo.setForeground(Color.white);
        lbLicenseNo.setBounds(20, 300, 184, 35);
        this.getContentPane().add(lbLicenseNo);
        JTextField specialization = new JTextField();
        specialization.setBounds(190, 400, 184, 35);
        specialization.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(specialization);
        specialization.setColumns(10);
        JLabel lbSpecialization = new JLabel("Specialization");
        lbSpecialization.setFont(new Font("Tahoma", 0, 20));
        lbSpecialization.setForeground(Color.white);
        lbSpecialization.setBounds(20, 400, 184, 35);
        this.getContentPane().add(lbSpecialization);
        JLabel print1 = new JLabel("Patient's Details ");
        print1.setFont(new Font("Tahoma", 0, 25));
        print1.setForeground(Color.white);
        print1.setBounds(700, 30, 184, 20);
        this.getContentPane().add(print1);
        JTextField patientId = new JTextField();
        patientId.setBounds(850, 100, 184, 35);
        patientId.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(patientId);
        JLabel lblId = new JLabel("Patient Id");
        lblId.setFont(new Font("Tahoma", 0, 20));
        lblId.setForeground(Color.white);
        lblId.setBounds(700, 100, 184, 35);
        this.getContentPane().add(lblId);
        JTextField patientName = new JTextField();
        patientName.setBounds(850, 200, 184, 35);
        patientName.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(patientName);
        JLabel lblFName = new JLabel("Name");
        lblFName.setFont(new Font("Tahoma", 0, 20));
        lblFName.setForeground(Color.white);
        lblFName.setBounds(700, 200, 184, 35);
        this.getContentPane().add(lblFName);
        JTextField txtsurname = new JTextField();
        txtsurname.setBounds(850, 300, 184, 35);
        txtsurname.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtsurname);
        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setFont(new Font("Tahoma", 0, 20));
        lblSurname.setForeground(Color.white);
        lblSurname.setBounds(700, 300, 184, 35);
        this.getContentPane().add(lblSurname);
        JTextField pMobileNo = new JTextField();
        pMobileNo.setBounds(850, 400, 184, 35);
        pMobileNo.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(pMobileNo);
        JLabel lblMobileNo = new JLabel("Mobile Number");
        lblMobileNo.setFont(new Font("Tahoma", 0, 20));
        lblMobileNo.setForeground(Color.white);
        lblMobileNo.setBounds(700, 400, 184, 35);
        this.getContentPane().add(lblMobileNo);
        JTextField txtDate = new JTextField();
        txtDate.setBounds(300, 500, 184, 35);
        txtDate.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtDate);
        JLabel lblDate = new JLabel("Consultation Date");
        lblDate.setFont(new Font("Tahoma", 0, 20));
        lblDate.setForeground(Color.white);
        lblDate.setBounds(100, 500, 184, 35);
        this.getContentPane().add(lblDate);
        JTextField cost = new JTextField();
        cost.setBounds(500, 650, 184, 35);
        cost.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(cost);
        JLabel lblCost = new JLabel("Consultation Cost");
        lblCost.setFont(new Font("Tahoma", 0, 20));
        lblCost.setForeground(Color.white);
        lblCost.setBounds(300, 650, 184, 35);
        this.getContentPane().add(lblCost);
        JTextField txtTime = new JTextField();
        txtTime.setBounds(750, 500, 184, 35);
        txtTime.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtTime);
        JLabel lblTime = new JLabel("Consultation Time");
        lblTime.setFont(new Font("Tahoma", 0, 20));
        lblTime.setForeground(Color.white);
        lblTime.setBounds(550, 500, 184, 35);
        this.getContentPane().add(lblTime);
        JTextField txtNotes = new JTextField();
        txtNotes.setBounds(890, 650, 200, 100);
        txtNotes.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtNotes);
        JLabel lblNotes = new JLabel("Notes");
        lblNotes.setFont(new Font("Tahoma", 0, 20));
        lblNotes.setForeground(Color.white);
        lblNotes.setBounds(800, 650, 184, 35);
        this.getContentPane().add(lblNotes);

        JTextField txtImage = new JTextField();
        txtImage.setBounds(890, 770, 200, 50);
        txtImage.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtImage);
        JLabel lblImage = new JLabel("Image");
        lblImage.setFont(new Font("Tahoma", 0, 20));
        lblImage.setForeground(Color.white);
        lblImage.setBounds(800, 770, 184, 35);
        this.getContentPane().add(lblImage);

        JButton button = new JButton("Back");
        button.setFont(new Font("Arial", 1, 18));
        this.getContentPane().add(button);
        button.setBounds(890, 1000, 184, 40);

        // this will navigate to the previous window once the button is clicked.
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DisplayTableForm();
                DisplayStatus.this.setVisible(false);
            }
        });

        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayStatus();
    }
}

