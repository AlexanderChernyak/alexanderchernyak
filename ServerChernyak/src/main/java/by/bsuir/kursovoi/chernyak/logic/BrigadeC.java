package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.DAO.BrigadeOtlov;
import by.bsuir.kursovoi.chernyak.db.DAO.BrigadeOtlovInter;
import by.bsuir.kursovoi.chernyak.db.DAO.VetDoctor;
import by.bsuir.kursovoi.chernyak.db.DAO.VetDoctorInter;
import by.bsuir.kursovoi.chernyak.db.model.Brigade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrigadeC implements BrigadeInter{
    
     @Override
    public List getBrigade() {
        BrigadeOtlovInter brinter = new BrigadeOtlov();
        return brinter.getBrigadeOtlov();
    }
    
     @Override
    public void deleteBrigade(Brigade brigade) {
        BrigadeOtlovInter brinter = new BrigadeOtlov();
        brinter.delete(brigade.getId());
    }

    @Override
    public String getSurname(int id) {
        BrigadeOtlovInter brinter = new BrigadeOtlov();
        Brigade brigade = (Brigade) brinter.read(id);
        Logger.getLogger(BrigadeAddC.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  brigade.getSurname();
    }

    @Override
    public int getBrigadeId(String surname) {
        BrigadeOtlovInter brinter = new BrigadeOtlov();
        Brigade brigade = (Brigade) brinter.getBrigadeOtlovByName(surname);
        Logger.getLogger(BrigadeAddC.class.getName()).log(Level.SEVERE, "Отправка ID Бригады");
        return  brigade.getId();
    }
    
     @Override
    public List filterBrigade(String str){
        BrigadeOtlovInter brigadeint = new BrigadeOtlov();
        return brigadeint.getBrigadeFilter(str);
    }
}
