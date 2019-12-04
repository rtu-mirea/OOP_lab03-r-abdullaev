package com.company;

public class Elector extends User {
    private Boolean voted;

    public Elector(String name, String login, String password){
        add(name, login, password);
        voted = false;
    }
    public Boolean isVoted(){return voted;}
    public void vote(){voted = true;}
}
