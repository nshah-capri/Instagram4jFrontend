package com.instagram4jautomation.bean;

import com.capri.nshah.Instagram;
import com.github.instagram4j.instagram4j.IGClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserBean {
    Instagram instagram;
    IGClient client;
    String username;

    String user;
    String password;

    public Instagram getInstagram() {
        return instagram;
    }

    public void setInstagram(Instagram instagram) {
        this.instagram = instagram;
    }

    public IGClient getClient() {
        return instagram.getClient();
    }
    public void setClient(IGClient client) {
        this.client = instagram.getClient();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
