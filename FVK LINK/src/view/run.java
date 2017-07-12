/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author duong
 */
public class run {
    public static void main(String[] args) {
        MainGUI main = new MainGUI();
        Login login = new Login();
        login.setVisible(true);
        if(!login.isVisible()){
            main.setVisible(true);
        }
    }
}
