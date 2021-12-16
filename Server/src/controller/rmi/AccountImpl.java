/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.rmi;

import controller.db.ConnectDB;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Account;

/**
 *
 * @author Hoang Pham
 */
public class AccountImpl extends UnicastRemoteObject implements IAccount{
    public Connection conn; 
    Statement statement;
    PreparedStatement preStatement;
    ResultSet res;
    
    public AccountImpl() throws RemoteException, SQLException, 
            ClassNotFoundException {
        super();
        this.conn = ConnectDB.getMyConnection();
        this.statement = this.conn.createStatement();
    } 

    @Override
    public Account FindByUsn(String usn) throws RemoteException {
        int rowCount = 0;
        Account acc = null;
        try {
            String sql = " SELECT * FROM Account WHERE "
                    + " UserName = ?;";
            
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, usn);
            res = this.preStatement.executeQuery();
            while (res.next()) {
                acc = new Account(
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4),
                        res.getString(5),
                        res.getString(6));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }

    @Override
    public int SignUp(Account acc) throws RemoteException {
        int rowCount = 0;
        try {
            String sql = " INSERT INTO Account VALUES (?,?,?,?,?,?); ";
            
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, acc.getUserName());
            this.preStatement.setString(2, acc.getPassWord());
            this.preStatement.setString(3, acc.getFullName());
            this.preStatement.setInt(4, acc.getSex());
            this.preStatement.setString(5, acc.getEmail());
            this.preStatement.setString(6, acc.getAddress());
            rowCount = this.preStatement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    @Override
    public int UpdatePassword(String usn, String pwd) throws RemoteException {
        int rowCount = 0;
        try {
            String sql = " UPDATE Account SET "
                    + "PassWord = ?"
                    + "WHERE UserName = ?; ";
            
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, pwd);
            this.preStatement.setString(2, usn);
            rowCount = this.preStatement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    @Override
    public int UpdateAccount(Account newAcc) throws RemoteException {
        int rowCount = 0;
        try {
            String sql = " UPDATE Account SET "
                    + "FullName = ?, "
                    + "Sex = ?, "
                    + "Email = ?, "
                    + "Address = ? "
                    + "WHERE UserName = ?; ";
            
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, newAcc.getFullName());
            this.preStatement.setInt(2, newAcc.getSex());
            this.preStatement.setString(3, newAcc.getEmail());
            this.preStatement.setString(4, newAcc.getAddress());
            this.preStatement.setString(5, newAcc.getUserName());
            rowCount = this.preStatement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
