package com.help.app_msg.models;

public class helpMsg {

    private int id;

    private String name;

    private String status;

    private user user;

    public helpMsg(int id, String name, String status , user user){
        this.id = id;
        this.name = name;
        this.status = status;
        this.user = user;
    }

    public user getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
