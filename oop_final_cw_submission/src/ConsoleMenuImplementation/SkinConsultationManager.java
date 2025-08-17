package ConsoleMenuImplementation;

import java.io.IOException;
import java.util.ArrayList;

public interface SkinConsultationManager {

    // create abstract methods that will be implemented in the WestminsterSkinCareConsultationManager class.
    void AddDoctor(ArrayList<Doctor> var1);

    void DeleteDoctor(ArrayList<Doctor> var1);

    void PrintDoctors(ArrayList<Doctor> var1);

    void SaveInFile(ArrayList<Doctor> var1) throws IOException;
}
