/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.DAO.BrigadeOtlov;
import by.bsuir.kursovoi.chernyak.db.DAO.BrigadeOtlovInter;
import by.bsuir.kursovoi.chernyak.db.model.Brigade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Александр
 */
public class BrigadeAddC implements BrigadeAddInter{
    
    @Override
    public String getSurname(int id) {
        BrigadeOtlovInter brinter = new BrigadeOtlov();
        Brigade brigade = (Brigade) brinter.read(id);
        Logger.getLogger(BrigadeAddC.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  brigade.getSurname();
    }

    @Override
    public List getBrigade() {
        BrigadeOtlovInter brinter = new BrigadeOtlov();
        return brinter.getBrigadeOtlov();
    }

    @Override
    public void saveBrigade(Brigade brigade) {
        BrigadeOtlovInter brinter = new BrigadeOtlov();
         if(brigade.getId() == 0) {
             Logger.getLogger(BrigadeAddC.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", brigade.toString());
             brinter.create(brigade);
         } else {
             Logger.getLogger(BrigadeAddC.class.getName()).log(Level.SEVERE, "Обновление данных о бригаде");
             brinter.update(brigade);
         } 
    }

    @Override
    public int getBrigadeId(String surname) {
        BrigadeOtlovInter brinter = new BrigadeOtlov();
        Brigade brigade = (Brigade) brinter.getBrigadeOtlovByName(surname);
        Logger.getLogger(BrigadeAddC.class.getName()).log(Level.SEVERE, "Отправка ID бригады");
        return  brigade.getId();
    }
}
