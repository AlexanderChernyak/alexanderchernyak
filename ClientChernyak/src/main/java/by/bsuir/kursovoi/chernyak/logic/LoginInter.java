/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kursovoi.chernyak.logic;

import java.io.Serializable;

/**
 *
 * @author Александр
 */
public interface LoginInter extends Serializable{
    
    public boolean login(String login, String password);
            }
