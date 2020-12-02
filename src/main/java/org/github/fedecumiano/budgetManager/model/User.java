package org.github.fedecumiano.budgetManager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String pass;

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }


    public User(){
        this.username = "";
        this.pass = "";
    }

}
