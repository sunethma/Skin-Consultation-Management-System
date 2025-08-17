package GuiImplementation;

import javax.swing.*;

public class MainGUI {

    public MainGUI() {
        // Initialize the main GUI interface
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create and display the doctor table (main GUI window)
                new DoctorTable();
            }
        });
    }
}