package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.DAO.AnimalPit;
import by.bsuir.kursovoi.chernyak.db.DAO.AnimalPitInter;
import by.bsuir.kursovoi.chernyak.db.model.Animal;
import java.util.List;

public class AnimalC implements AnimalInter{
    
    @Override
     public List getAnimal() {
        AnimalPitInter aniinter = new AnimalPit();
        return aniinter.getAnimalPit();
    }
    
     @Override
    public void deleteAnimal(Animal animal) {
        AnimalPitInter aniinter = new AnimalPit();
        aniinter.delete(animal.getId());
    }
    
    @Override
    public List filterAnimalByKind(String str){
        AnimalPitInter aniinter = new AnimalPit();
        return aniinter.getAnimalFilterByKind(str);
    }
    
    @Override
    public List filterAnimalBySpecies(String str){
        AnimalPitInter aniinter = new AnimalPit();
        return aniinter.getAnimalFilterBySpecies(str);
    }
    
    @Override
    public List filterAnimalBySex(String str){
        AnimalPitInter aniinter = new AnimalPit();
        return aniinter.getAnimalFilterBySex(str);
    }
    
    @Override
    public int StatCountCat(String str){
        AnimalPitInter aniinter = new AnimalPit();
        return aniinter.getStatCountCat(str);
    }
    
    @Override
    public int StatCountDog(String str){
        AnimalPitInter aniinter = new AnimalPit();
        return aniinter.getStatCountCat(str);
    }
}
