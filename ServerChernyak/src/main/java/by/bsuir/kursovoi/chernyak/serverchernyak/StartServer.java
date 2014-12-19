/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.serverchernyak;

import by.bsuir.kursovoi.chernyak.manager.Entity;
import by.bsuir.kursovoi.chernyak.manager.EntityInter;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Александр
 */
public class StartServer {

    private static int curr_port = -1;
    private static Registry registry = null;
    private static EntityInter usersAct = null;
    private static Remote uaStub = null;
        
    public static void main(String[] args) {
         
            try {
                if (curr_port != 2099) {
                    if (registry != null) {
                        UnicastRemoteObject.unexportObject(registry, true);
                    }
                    curr_port = 2099;
                }

                registry = LocateRegistry.createRegistry(curr_port);

                if (usersAct == null) {
                    usersAct = new Entity();
                }

                if (uaStub == null) {
                    uaStub = UnicastRemoteObject.exportObject(usersAct, 0);
                }

                registry.bind("UsersActivities", uaStub);

        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
