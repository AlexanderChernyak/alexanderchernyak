package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.model.DBaseObjectAbsrt;
import java.util.List;

public interface VetDoctorInter extends DAOFunctionsInter{
    public List getVetDoctor();
    public DBaseObjectAbsrt getVetDoctorByName(String surname);
    public List getVetFilter(String str);
    public int getId_vet(String str);
    
}
