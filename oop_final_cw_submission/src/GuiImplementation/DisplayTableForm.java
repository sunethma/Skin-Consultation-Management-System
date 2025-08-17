package GuiImplementation;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ConsoleMenuImplementation.*;
public class DisplayTableForm extends JFrame {
    static int selectedRowIndex;

    public DisplayTableForm() {
        this.setTitle("Consultation Details");
        this.setDefaultCloseOperation(2);
        // pass the columns names into an object array.
        Object[] columns = new Object[]{"Doctor First Name", "Doctor Surname", "Medical License No", "Specialization", "Patient Id", "Patient Name", "Patient Surname", "Patient Mobile no"};
        // to display the consultation details in a 2d manner(in a table format).
        final JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        this.getContentPane().setBackground(new Color(105,105,105));
        this.setBounds(200, 200, 1700, 980);
        this.getContentPane().setLayout((LayoutManager)null);
        this.setLocationRelativeTo((Component)null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        // add the necessary colors to the table.
        table.setBackground(Color.black);
        table.setForeground(Color.white);
        table.setGridColor(Color.white);
        table.setSelectionBackground(new Color(169,169,169));
        table.setFont(new Font("Tahoma", 1, 17));
        table.setRowHeight(45);
        table.setAutoCreateRowSorter(true);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.gray);
        header.setFont(new Font("Tahoma", 1, 17));
        JScrollPane pane = new JScrollPane(table);
        table.setAutoResizeMode(4);
        pane.setForeground(Color.red);
        pane.setBounds(50, 20, 1600, 200);
        this.getContentPane().add(pane);
        //creates all the relevant labels and text-feilds
        JLabel print = new JLabel("Doctor's Details ");
        print.setFont(new Font("Tahoma", 0, 25));
        print.setForeground(Color.white);
        print.setBounds(20, 300, 184, 20);
        this.getContentPane().add(print);
        final JTextField textFirstName = new JTextField();
        textFirstName.setBounds(190, 400, 184, 35);
        textFirstName.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(textFirstName);
        textFirstName.setColumns(10);
        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setFont(new Font("Tahoma", 0, 20));
        lbFirstName.setForeground(Color.white);
        lbFirstName.setBounds(20, 400, 184, 35);
        this.getContentPane().add(lbFirstName);
        final JTextField surname = new JTextField();
        surname.setBounds(190, 500, 184, 35);
        surname.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(surname);
        surname.setColumns(10);
        JLabel lbSurname = new JLabel("Surname");
        lbSurname.setFont(new Font("Tahoma", 0, 20));
        lbSurname.setForeground(Color.white);
        lbSurname.setBounds(20, 500, 184, 35);
        this.getContentPane().add(lbSurname);
        final JTextField licenseNo = new JTextField();
        licenseNo.setBounds(190, 600, 184, 35);
        licenseNo.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(licenseNo);
        licenseNo.setColumns(10);
        JLabel lbLicenseNo = new JLabel("License Number");
        lbLicenseNo.setFont(new Font("Tahoma", 0, 20));
        lbLicenseNo.setForeground(Color.white);
        lbLicenseNo.setBounds(20, 600, 184, 35);
        this.getContentPane().add(lbLicenseNo);
        final JTextField specialization = new JTextField();
        specialization.setBounds(190, 700, 184, 35);
        specialization.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(specialization);
        specialization.setColumns(10);
        JLabel lbSpecialization = new JLabel("Specialization");
        lbSpecialization.setFont(new Font("Tahoma", 0, 20));
        lbSpecialization.setForeground(Color.white);
        lbSpecialization.setBounds(20, 700, 184, 35);
        this.getContentPane().add(lbSpecialization);
        JLabel print1 = new JLabel("Patient's Details ");
        print1.setFont(new Font("Tahoma", 0, 25));
        print1.setForeground(Color.white);
        print1.setBounds(1000, 300, 184, 20);
        this.getContentPane().add(print1);
        final JTextField patientId = new JTextField();
        patientId.setBounds(850, 400, 184, 35);
        patientId.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(patientId);
        JLabel lblId = new JLabel("Patient Id");
        lblId.setFont(new Font("Tahoma", 0, 20));
        lblId.setForeground(Color.white);
        lblId.setBounds(700, 400, 184, 35);
        this.getContentPane().add(lblId);
        final JTextField patientName = new JTextField();
        patientName.setBounds(850, 500, 184, 35);
        patientName.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(patientName);
        JLabel lblFName = new JLabel("Name");
        lblFName.setFont(new Font("Tahoma", 0, 20));
        lblFName.setForeground(Color.white);
        lblFName.setBounds(700, 500, 184, 35);
        this.getContentPane().add(lblFName);
        final JTextField txtSurname = new JTextField();
        txtSurname.setBounds(850, 600, 184, 35);
        txtSurname.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtSurname);
        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setFont(new Font("Tahoma", 0, 20));
        lblSurname.setForeground(Color.white);
        lblSurname.setBounds(700, 600, 184, 35);
        this.getContentPane().add(lblSurname);
        final JTextField pMobileNo = new JTextField();
        pMobileNo.setBounds(850, 700, 184, 35);
        pMobileNo.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(pMobileNo);
        JLabel lblMobileNo = new JLabel("Mobile Number");
        lblMobileNo.setFont(new Font("Tahoma", 0, 20));
        lblMobileNo.setForeground(Color.white);
        lblMobileNo.setBounds(700, 700, 184, 35);
        this.getContentPane().add(lblMobileNo);
        final JTextField txtDate = new JTextField();
        txtDate.setBounds(1400, 400, 184, 35);
        txtDate.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtDate);
        JLabel lblDate = new JLabel("Consultation Date");
        lblDate.setFont(new Font("Tahoma", 0, 20));
        lblDate.setForeground(Color.white);
        lblDate.setBounds(1180, 400, 184, 35);
        this.getContentPane().add(lblDate);
        final JTextField cost = new JTextField();
        cost.setBounds(1400, 500, 184, 35);
        cost.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(cost);
        JLabel lblCost = new JLabel("Consultation Cost");
        lblCost.setFont(new Font("Tahoma", 0, 20));
        lblCost.setForeground(Color.white);
        lblCost.setBounds(1180, 500, 184, 35);
        this.getContentPane().add(lblCost);
        final JTextField txtTime = new JTextField();
        txtTime.setBounds(1400, 600, 184, 35);
        txtTime.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtTime);
        JLabel lblTime = new JLabel("Consultation Time");
        lblTime.setFont(new Font("Tahoma", 0, 20));
        lblTime.setForeground(Color.white);
        lblTime.setBounds(1180, 600, 184, 35);
        this.getContentPane().add(lblTime);
        final JTextField txtNotes = new JTextField();
        txtNotes.setBounds(1400, 700, 200, 100);
        txtNotes.setFont(new Font("Tamoha", 1, 19));
        this.getContentPane().add(txtNotes);
        JLabel lblNotes = new JLabel("Notes");
        lblNotes.setFont(new Font("Tahoma", 0, 20));
        lblNotes.setForeground(Color.white);
        lblNotes.setBounds(1180, 700, 184, 35);
        this.getContentPane().add(lblNotes);


        JButton button = new JButton("Back");
        button.setFont(new Font("Arial", 1, 18));
        this.getContentPane().add(button);
        button.setBounds(1400, 840, 184, 40);
        button.setBackground(Color.WHITE);
        //this will navigate to the previous window once the back button is clicked.
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PatientDetailsForm();
                DisplayTableForm.this.setVisible(false);
            }
        });
        // this will allow to add all the consultation details in the consultationArrayList to the object array objs.
        for(int i = 0; i < DoctorTable.consultationArrayList.size(); ++i) {
            // adds all the consultation details to the object array named objs.
            Object[] objs = new Object[]{((Consultation) DoctorTable.consultationArrayList.get(i)).getDoctor().getName(), ((Consultation) DoctorTable.consultationArrayList.get(i)).getDoctor().getSurname(),
                    ((Consultation) DoctorTable.consultationArrayList.get(i)).getDoctor().getLicenceNo(), ((Consultation) DoctorTable.consultationArrayList.get(i)).getDoctor().getSpecialisation(),
                    ((Consultation) DoctorTable.consultationArrayList.get(i)).getPatient().getPatientId(), ((Consultation) DoctorTable.consultationArrayList.get(i)).getPatient().getName(),
                    ((Consultation) DoctorTable.consultationArrayList.get(i)).getPatient().getSurname(), ((Consultation) DoctorTable.consultationArrayList.get(i)).getPatient().getMobileNo(),
                    ((Consultation) DoctorTable.consultationArrayList.get(i)).getDate(), ((Consultation) DoctorTable.consultationArrayList.get(i)).getTime()};
            model.addRow(objs);
        }
       // Once a row is clicked,this will obtain all the relevant information regarding the consultation from the table and add them to the relevant
        //text-fields for the user to be seen.
        ListSelectionModel model1 = table.getSelectionModel();
        model1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                DisplayTableForm.selectedRowIndex = table.getSelectedRow();
                textFirstName.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getDoctor().getName());
                surname.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getDoctor().getSurname());
                licenseNo.setText(String.valueOf(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getDoctor().getLicenceNo()));
                specialization.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getDoctor().getSpecialisation());
                patientId.setText(String.valueOf(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getPatient().getPatientId()));
                patientName.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getPatient().getName());
                txtSurname.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getPatient().getSurname());
                pMobileNo.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getPatient().getMobileNo());
                cost.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getCost());
                txtNotes.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getNotes());
                txtDate.setText(String.valueOf(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getDate()));
                txtTime.setText(((Consultation) DoctorTable.consultationArrayList.get(DisplayTableForm.selectedRowIndex)).getTime());
               // this will make the text-fields uneditable.
                textFirstName.setEditable(false);
                surname.setEditable(false);
                licenseNo.setEditable(false);
                specialization.setEditable(false);
                patientId.setEditable(false);
                patientName.setEditable(false);
                txtSurname.setEditable(false);
                pMobileNo.setEditable(false);
                cost.setEditable(false);
               // txtNotes.setEditable(false);
                txtDate.setEditable(false);
                txtTime.setEditable(false);
            }
        });
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayTableForm();
    }
}

