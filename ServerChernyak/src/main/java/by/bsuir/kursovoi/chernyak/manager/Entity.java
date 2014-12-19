/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.manager;

import by.bsuir.kursovoi.chernyak.logic.AnimalAddC;
import by.bsuir.kursovoi.chernyak.logic.AnimalAddInter;
import by.bsuir.kursovoi.chernyak.logic.AnimalC;
import by.bsuir.kursovoi.chernyak.logic.AnimalInter;
import by.bsuir.kursovoi.chernyak.logic.BrigadeAddC;
import by.bsuir.kursovoi.chernyak.logic.BrigadeAddInter;
import by.bsuir.kursovoi.chernyak.logic.BrigadeC;
import by.bsuir.kursovoi.chernyak.logic.BrigadeInter;
import by.bsuir.kursovoi.chernyak.logic.Login;
import by.bsuir.kursovoi.chernyak.logic.LoginInter;
import by.bsuir.kursovoi.chernyak.logic.VetAddC;
import by.bsuir.kursovoi.chernyak.logic.VetAddInter;
import by.bsuir.kursovoi.chernyak.logic.VetC;
import by.bsuir.kursovoi.chernyak.logic.VetInter;
import java.rmi.RemoteException;


/**
 *
 * @author Александр
 */
public class Entity implements EntityInter{

    @Override
    public synchronized LoginInter getLoginManager() throws RemoteException {
        return new Login();
    }
        
    @Override
    public VetInter getVetManager() throws RemoteException {
        return new VetC();
    }

    @Override
    public VetAddInter getVetAddManager() throws RemoteException {
        return new VetAddC();
    }
    
    @Override
    public BrigadeInter getBrigadeManager() throws RemoteException {
        return new BrigadeC();
    }

    @Override
    public BrigadeAddInter getBrigadeAddManager() throws RemoteException {
        return new BrigadeAddC();
    }

    @Override
    public AnimalInter getAnimalManager() throws RemoteException {
        return new AnimalC();
    }

    @Override
    public AnimalAddInter getAnimalAddManager() throws RemoteException {
        return new AnimalAddC();
    }

}
