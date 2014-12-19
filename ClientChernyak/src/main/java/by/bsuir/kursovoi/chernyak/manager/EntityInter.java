/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.manager;

import by.bsuir.kursovoi.chernyak.logic.AnimalAddInter;
import by.bsuir.kursovoi.chernyak.logic.AnimalInter;
import by.bsuir.kursovoi.chernyak.logic.BrigadeAddInter;
import by.bsuir.kursovoi.chernyak.logic.BrigadeInter;
import by.bsuir.kursovoi.chernyak.logic.LoginInter;
import by.bsuir.kursovoi.chernyak.logic.VetAddInter;
import by.bsuir.kursovoi.chernyak.logic.VetInter;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Александр
 */
public interface EntityInter extends Remote{

    /**
     *
     * @return
     * @throws RemoteException
     */
    public LoginInter getLoginManager() throws RemoteException;
    public VetInter getVetManager() throws RemoteException;
    public VetAddInter getVetAddManager() throws RemoteException;
    public BrigadeInter getBrigadeManager() throws RemoteException;
    public BrigadeAddInter getBrigadeAddManager() throws RemoteException;
    public AnimalInter getAnimalManager() throws RemoteException;
    public AnimalAddInter getAnimalAddManager() throws RemoteException;
}
