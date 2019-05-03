package com.accountm.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yaghobabbai on 2/1/2019.
 */
@Entity
public class Transaction {
    private int id;
    private Timestamp createdate;
    private String fromaccount;
    private String toaccount;
    private long amount;
    private int transactiontype;
    private String description;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "createdate")
    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    @Basic
    @Column(name = "fromaccount")
    public String getFromaccount() {
        return fromaccount;
    }

    public void setFromaccount(String fromaccount) {
        this.fromaccount = fromaccount;
    }

    @Basic
    @Column(name = "toaccount")
    public String getToaccount() {
        return toaccount;
    }

    public void setToaccount(String toaccount) {
        this.toaccount = toaccount;
    }

    @Basic
    @Column(name = "amount")
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (createdate != null ? !createdate.equals(that.createdate) : that.createdate != null) return false;
        if (fromaccount != null ? !fromaccount.equals(that.fromaccount) : that.fromaccount != null) return false;
        if (toaccount != null ? !toaccount.equals(that.toaccount) : that.toaccount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        result = 31 * result + (fromaccount != null ? fromaccount.hashCode() : 0);
        result = 31 * result + (toaccount != null ? toaccount.hashCode() : 0);
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        return result;
    }

    @Basic
    @Column(name = "transactiontype")
    public int getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(int transactiontype) {
        this.transactiontype = transactiontype;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
