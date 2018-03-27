package com.ags.pawn.services.agsPawnService.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by dagraw2 on 3/25/18.
 */
@Entity
@Table(name="base_transaction")
@AttributeOverride(name = "id", column = @Column(name = "base_transaction_pk"))
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseTransaction extends BaseEntity{
    private Customer customer;
    private String principal;
    private String interestRate;
    private String itemType;
    private String note;
    private Boolean isActive = true;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable=false, updatable=false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name="principal", nullable=false)
    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @Column(name="interest_rate", nullable=false)
    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    @Column(name="item_type")
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Column(name="note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name="is_active")
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "{" +
                "customer=" + customer.getId() +
                ", principal='" + principal + '\'' +
                ", interestRate='" + interestRate + '\'' +
                ", itemType='" + itemType + '\'' +
                ", note='" + note + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
