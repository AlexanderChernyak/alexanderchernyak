package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.DAO.VetDoctor;
import by.bsuir.kursovoi.chernyak.db.DAO.VetDoctorInter;
import by.bsuir.kursovoi.chernyak.db.model.Vet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VetC implements VetInter{
    
     @Override
    public List getVet() {
        VetDoctorInter vetint = new VetDoctor();
        return vetint.getVetDoctor();
    }
    
     @Override
    public void deleteVet(Vet vet) {
        VetDoctorInter vetint = new VetDoctor();
        vetint.delete(vet.getId());
    }

    @Override
    public String getSurname(int id) {
        VetDoctorInter vetint = new VetDoctor();
        Vet vet = (Vet) vetint.read(id);
        Logger.getLogger(VetAddC.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  vet.getSurname();
    }

    @Override
    public int getVetId(String surname) {
        VetDoctorInter vetint = new VetDoctor();
        Vet vet = (Vet) vetint.getVetDoctorByName(surname);
        Logger.getLogger(VetAddC.class.getName()).log(Level.SEVERE, "Отправка ID ветеринара");
        return  vet.getId();
    }
    
    @Override
    public List filterVet(String str) {
        VetDoctorInter vetint = new VetDoctor();
        return vetint.getVetFilter(str);
    }
    
    /*@Override
    public int searchVet(String str) {
        VetDoctorInter vetint = new VetDoctor();
        return vetint.getId_vet(str);
    }*/
}
