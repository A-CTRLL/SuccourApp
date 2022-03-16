package com.example.succourapp;

public class UserHelperClass {


    String firstname, lastname, number, emailaddress, password, passwordconfirm;

    public UserHelperClass() {

    }


    public UserHelperClass(String firstname, String lastname, String number, String emailaddress, String password, String passwordconfirm) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
        this.emailaddress = emailaddress;
        this.password = password;
        this.passwordconfirm = passwordconfirm;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordconfirm() {
        return passwordconfirm;
    }

    public void setPasswordconfirm(String passwordconfirm) {
        this.passwordconfirm = passwordconfirm;
    }
}
