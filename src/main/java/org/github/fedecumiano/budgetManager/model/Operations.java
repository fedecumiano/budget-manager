package org.github.fedecumiano.budgetManager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Operations {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="description")
    private String description;

    @Column(name="amount")
    private double amount;

    @Column(name="dated")
    private String dated;

    @Column(name="type")
    private String type;   // Income/Spent

    public Operations(String username, String desc, double amount, String dated, String type) {
        this.id = 0;
        this.username = username;
        this.description = desc;
        this.amount = amount;
        this.dated = dated;
        this.type = type;
    }

    public Operations(){
        this.id = 0;
        this.username = "";
        this.description = "";
        this.amount = 0;
        this.dated = "";
        this.type = "";
    }
}
