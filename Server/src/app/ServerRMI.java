/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.rmi.AccountImpl;
import controller.rmi.IAccount;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Hoang Pham
 */
public class ServerRMI {

    public ServerRMI() {
        try {
            IAccount iacc = new AccountImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/ServerAcc", iacc);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
