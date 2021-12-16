/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Account;

/**
 *
 * @author Hoang Pham
 */
public interface IAccount extends Remote {
    public Account FindByUsn(String usn) throws RemoteException;
    public int SignUp(Account acc) throws RemoteException;
    public int UpdatePassword(String usn, String pwd) throws RemoteException;
    public int UpdateAccount(Account newAcc) throws RemoteException;
}
