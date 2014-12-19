/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.logic;

import by.bsuir.kursovoi.chernyak.db.DAO.UserAd;
import by.bsuir.kursovoi.chernyak.db.DAO.UserAdInter;
import by.bsuir.kursovoi.chernyak.db.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Александр
 */
public class Login implements LoginInter{
    
    @Override
    public boolean login(String login, String password) {
        UserAdInter udao = new UserAd();
        User user = (User) udao.getUserAdByName(login);
        if(user != null) {
            if(password.equals(user.getPassword())){
                Logger.getLogger("Аутентификация пройдена пользователем: " + login);
                return true;
            }
        }
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "Аутентификация не пройдена");
        return false;
    }
    
}
