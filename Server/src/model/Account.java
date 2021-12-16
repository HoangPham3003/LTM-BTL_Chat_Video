/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Hoang Pham
 */
public class Account implements Serializable {

    private String UserName;
    private String PassWord;
    private String FullName;
    private int Sex;
    private String Email;
    private String Address;
    
    public Account() {
    }
    
    public Account(String UserName, String PassWord, String FullName, int Sex, String Email, String Address) {
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.FullName = FullName;
        this.Sex = Sex;
        this.Email = Email;
        this.Address = Address;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int Sex) {
        this.Sex = Sex;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
}
