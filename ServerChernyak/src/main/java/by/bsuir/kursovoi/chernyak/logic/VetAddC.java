/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.DAO.VetDoctor;
import by.bsuir.kursovoi.chernyak.db.DAO.VetDoctorInter;
import by.bsuir.kursovoi.chernyak.db.model.Vet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Александр
 */
public class VetAddC implements VetAddInter{
    
    @Override
    public String getSurname(int id) {
        VetDoctorInter vetint = new VetDoctor();
        Vet vet = (Vet) vetint.read(id);
        Logger.getLogger(VetAddC.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  vet.getSurname();
    }

    @Override
    public List getVet() {
        VetDoctorInter vetint = new VetDoctor();
        return vetint.getVetDoctor();
    }

    @Override
    public void saveVet(Vet vet) {
        VetDoctorInter vetint = new VetDoctor();
         if(vet.getId() == 0) {
             Logger.getLogger(VetAddC.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", vet.toString());
             vetint.create(vet);
         } else {
             Logger.getLogger(VetAddC.class.getName()).log(Level.SEVERE, "Обновление данных о ветеринарах");
             vetint.update(vet);
         } 
    }

    @Override
    public int getVetId(String name) {
        VetDoctorInter sdao = new VetDoctor();
        Vet seller = (Vet) sdao.getVetDoctorByName(name);
        Logger.getLogger(VetAddC.class.getName()).log(Level.SEVERE, "Отправка ID ветеринара");
        return  seller.getId();
    }
}
