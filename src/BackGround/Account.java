package BackGround;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Account {
    private String name;
    private String surName;
    private String ePosta;
    private String userName;
    private String password;


    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public Account(){

    }
    public abstract boolean control() throws IOException;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}