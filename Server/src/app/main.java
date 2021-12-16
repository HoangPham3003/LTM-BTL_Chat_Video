/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import view.ServerView;

/**
 *
 * @author Hoang Pham
 */
public class main {
    public static void main(String[] args) {
        new ServerView().setVisible(true);
        System.out.println("Server Socket is running!");
        new ServerRMI();
        System.out.println("Server RMI is running!");
    }
}
