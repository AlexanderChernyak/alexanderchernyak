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
public interface BrigadeInter extends Serializable{
    public List getBrigade();
    public int getBrigadeId(String surname);
    public void deleteBrigade(Brigade brigade);
    public String getSurname(int id);
    public List filterBrigade(String str);
}
