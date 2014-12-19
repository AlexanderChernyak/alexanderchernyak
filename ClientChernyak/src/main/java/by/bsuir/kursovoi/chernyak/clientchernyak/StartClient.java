/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.clientchernyak;

import by.bsuir.kursovoi.chernyak.manager.EntityInter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Александр
 */
public class StartClient {

    private static EntityInter entityManager = null;
    private StartClient() {        
    }
    public synchronized static EntityInter getEntityManager() {
        if (entityManager == null) {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost",
                        2099);
                entityManager = (EntityInter) registry
                        .lookup("UsersActivities");
                return entityManager;
            } catch (RemoteException | NotBoundException ex) {
                JOptionPane.showMessageDialog(null,"Сервер не отвечает! Проверьте подключение!");
                Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entityManager;
    }    
    
}
