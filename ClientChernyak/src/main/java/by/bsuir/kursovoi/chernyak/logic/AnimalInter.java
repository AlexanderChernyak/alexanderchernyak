/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.model.Animal;
import by.bsuir.kursovoi.chernyak.db.model.Brigade;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Александр
 */
public interface AnimalInter extends Serializable{
    public List getAnimal();
    public void deleteAnimal(Animal animal);
    public List filterAnimalByKind(String str);
    public List filterAnimalBySpecies(String str);
    public List filterAnimalBySex(String str);
    public int StatCountCat(String str);
    public int StatCountDog(String str);
    
}
