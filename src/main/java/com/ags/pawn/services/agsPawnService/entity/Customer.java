package com.ags.pawn.services.agsPawnService.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dagraw2 on 3/25/18.
 */
@Entity
@Table(name="customer")
@AttributeOverride(name = "id", column = @Column(name = "customer_pk"))
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    private String village;
    private String note;
    private List<BaseTransaction> baseTransactions;

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

//    @OneToMany(mappedBy = "customer", orphanRemoval = true, fetch = FetchType.LAZY)
    @Transient
    public List<BaseTransaction> getBaseTransactions() {
        return baseTransactions;
    }

    public void setBaseTransactions(List<BaseTransaction> baseTransactions) {
        this.baseTransactions = baseTransactions;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", village='" + village + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
