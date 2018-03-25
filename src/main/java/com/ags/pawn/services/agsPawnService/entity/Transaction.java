package com.ags.pawn.services.agsPawnService.entity;

import javax.persistence.*;

/**
 * Created by dagraw2 on 3/25/18.
 */
@Entity
@Table(name="transaction")
@NamedQuery(name = "Transaction.findAll", query = "SELECT p FROM Transaction p")
@AttributeOverride(name = "id", column = @Column(name = "transaction_pk"))
public class Transaction extends BaseEntity{
    private BaseTransaction baseTransaction;
    private String credit="0";
    private String debit="0";
    private String transactionType;
    private String note;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="base_transaction_pk")
    public BaseTransaction getBaseTransaction() {
        return baseTransaction;
    }

    public void setBaseTransaction(BaseTransaction baseTransaction) {
        this.baseTransaction = baseTransaction;
    }

    @Column(name="credit")
    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Column(name="debit")
    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    @Column(name="transaction_type")
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Column(name="note",nullable=false)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
