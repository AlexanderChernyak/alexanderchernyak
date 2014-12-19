package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.model.DBaseObjectAbsrt;
import java.util.List;

public interface BrigadeOtlovInter extends DAOFunctionsInter{
    public List getBrigadeOtlov();
    public DBaseObjectAbsrt getBrigadeOtlovByName(String surname);
    public List getBrigadeFilter(String str);
}
