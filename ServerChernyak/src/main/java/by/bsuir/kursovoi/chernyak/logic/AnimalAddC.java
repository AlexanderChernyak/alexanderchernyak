package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.DAO.AnimalPit;
import by.bsuir.kursovoi.chernyak.db.DAO.AnimalPitInter;
import by.bsuir.kursovoi.chernyak.db.model.Animal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimalAddC implements AnimalAddInter{
    
    @Override
    public String getKind(int id) {
        AnimalPitInter aniinter = new AnimalPit();
        Animal animal = (Animal) aniinter.read(id);
        Logger.getLogger(AnimalAddC.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  animal.getKind();
    }
    
    @Override
     public List getAnimal() {
        AnimalPitInter aniinter = new AnimalPit();
        return aniinter.getAnimalPit();
    }
     
    @Override
     public synchronized void saveAnimal(Animal animal) {
         AnimalPitInter bdao = new AnimalPit();
         if(animal.getId() == 0) {
             Logger.getLogger(AnimalAddC.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", animal.toString());
             bdao.create(animal);
         } else {
             Logger.getLogger(AnimalAddC.class.getName()).log(Level.SEVERE, "Обновление данных о животных");
             bdao.update(animal);
         } 
     }
     
    @Override
     public int getAnimalId(String kind) {
        AnimalPitInter sdao = new AnimalPit();
        Animal animal = (Animal) sdao.getAnimalPitByName(kind);
        Logger.getLogger(AnimalAddC.class.getName()).log(Level.SEVERE, "Отправка ID животного");
        return  animal.getId();
    }
}
