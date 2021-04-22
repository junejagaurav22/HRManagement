package com.humanresource.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HrLoginEntity {

    @Id
    private String username;
    @Column(name = "password")
    private String password;

    public HrLoginEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HrLoginEntity(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
