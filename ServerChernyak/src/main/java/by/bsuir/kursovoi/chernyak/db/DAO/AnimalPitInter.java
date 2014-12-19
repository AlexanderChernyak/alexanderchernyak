package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.model.DBaseObjectAbsrt;
import java.util.List;


public interface AnimalPitInter extends DAOFunctionsInter{
    public List getAnimalPit();
    public DBaseObjectAbsrt getAnimalPitByName(String kind);
    public List getAnimalFilterByKind(String str);
    public List getAnimalFilterBySpecies(String str);
    public List getAnimalFilterBySex(String str);
    public int getStatCountCat(String str);
    public int getStatCountDog(String str);
}
