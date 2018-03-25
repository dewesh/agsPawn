package com.ags.pawn.services.agsPawnService.entity;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

/**
 * Created by dagraw2 on 3/25/18.
 */
@Entity
@Table(name="customer")
@NamedQuery(name = "Customer.findAll", query = "SELECT p FROM Customer p")
@AttributeOverride(name = "id", column = @Column(name = "customer_pk"))
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    private String village;
    private String note;

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }
    @Column(name = "village")
    public String getVillage() {
        return village;
    }
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
