/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.model.Brigade;
import by.bsuir.kursovoi.chernyak.db.model.Vet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Александр
 */
public interface BrigadeAddInter extends Serializable{
    public String getSurname(int id);
    
     public List getBrigade();
     
     public void saveBrigade(Brigade brigade);
     
     public int getBrigadeId(String surname);
    
}
