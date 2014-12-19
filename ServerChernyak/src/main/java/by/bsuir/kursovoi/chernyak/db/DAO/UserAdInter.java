package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.model.DBaseObjectAbsrt;
import java.util.List;

public interface UserAdInter extends DAOFunctionsInter{
    public List getUserAd();
    public DBaseObjectAbsrt getUserAdByName(String login);
}
