package com.fsabino.javacodingtips.patterns_of_design.structural.adapter;

public class EmployeeLDAP {

    private String cn;
    private String surname;
    private String givenName;
    private String mail;

    public EmployeeLDAP(String cn, String surname, String givenName, String mail) {
        this.cn = cn;
        this.surname = surname;
        this.givenName = givenName;
        this.mail = mail;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCn() {
        return cn;
    }

    public String getSurname() {
        return surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getMail() {
        return mail;
    }


}
