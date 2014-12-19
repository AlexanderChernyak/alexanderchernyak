package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.model.Animal;
import java.io.Serializable;
import java.util.List;

public interface AnimalAddInter extends Serializable{
    public String getKind(int id);
    
     public List getAnimal();
     
     public void saveAnimal(Animal animal);
     
     public int getAnimalId(String name);
}
