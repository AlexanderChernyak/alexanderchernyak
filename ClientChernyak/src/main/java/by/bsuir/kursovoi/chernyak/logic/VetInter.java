/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.model.Vet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Александр
 */
public interface VetInter extends Serializable{
    public List getVet();
    public int getVetId(String name);
    public void deleteVet(Vet vet);
    public String getSurname(int id);
    //public int searchVet(String str);
    public List filterVet(String str);
    
}
