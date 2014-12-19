package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.model.DBaseObjectAbsrt;
import java.io.Serializable;

public interface DAOFunctionsInter extends Serializable{
    public int create(DBaseObjectAbsrt object);
    public DBaseObjectAbsrt read(int id);
    public void update(DBaseObjectAbsrt newObject);
    public void delete(int id);
}
