package com.example.mohamed.mazadateee.models;

public class User {

    private String name;
    private String image;
    private String userName;
    private String email;
    private String account;
    private String phone;
    private String ssn;
    private int balance;
    private String adress;
    private String password;
    private Boolean flag;



    public User(String name,String image,String userName,String email, String account, String phone, String ssn, int balance, String adress, String password ,Boolean flag) {
        this.name = "-----------";
        this.image ="" ;
        this.userName = "-----------";
        this.email = "-----------";
        this.account = "-----------";
        this.phone = "-----------";
        this.ssn = "-----------";
        this.balance = 0;
        this.adress = "-----------";
        this.password = "-----------";
        this.flag = true;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
