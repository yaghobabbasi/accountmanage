package com.accountm.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yaghobabbai on 2/11/2019.
 */
@Entity
public class Accountp {
    private String depositnumber;
    private String accounttype;
    private Long balance;
    private int userid;
    private String description;
    private int currency;
    private int depositstatus;
    private long availablebalance;
    private long blockamount;
    private String branchcode;
    private int id;
    private Timestamp createdate;
    private Timestamp updatedate;

    @Basic
    @Column(name = "depositnumber")
    public String getDepositnumber() {
        return depositnumber;
    }

    public void setDepositnumber(String depositnumber) {
        this.depositnumber = depositnumber;
    }

    @Basic
    @Column(name = "accounttype")
    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    @Basic
    @Column(name = "balance")
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "currency")
    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "depositstatus")
    public int getDepositstatus() {
        return depositstatus;
    }

    public void setDepositstatus(int depositstatus) {
        this.depositstatus = depositstatus;
    }

    @Basic
    @Column(name = "availablebalance")
    public long getAvailablebalance() {
        return availablebalance;
    }

    public void setAvailablebalance(long availablebalance) {
        this.availablebalance = availablebalance;
    }

    @Basic
    @Column(name = "blockamount")
    public long getBlockamount() {
        return blockamount;
    }

    public void setBlockamount(long blockamount) {
        this.blockamount = blockamount;
    }

    @Basic
    @Column(name = "branchcode")
    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accountp accountp = (Accountp) o;

        if (userid != accountp.userid) return false;
        if (currency != accountp.currency) return false;
        if (depositstatus != accountp.depositstatus) return false;
        if (availablebalance != accountp.availablebalance) return false;
        if (blockamount != accountp.blockamount) return false;
        if (id != accountp.id) return false;
        if (depositnumber != null ? !depositnumber.equals(accountp.depositnumber) : accountp.depositnumber != null)
            return false;
        if (accounttype != null ? !accounttype.equals(accountp.accounttype) : accountp.accounttype != null)
            return false;
        if (balance != null ? !balance.equals(accountp.balance) : accountp.balance != null) return false;
        if (description != null ? !description.equals(accountp.description) : accountp.description != null)
            return false;
        if (branchcode != null ? !branchcode.equals(accountp.branchcode) : accountp.branchcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depositnumber != null ? depositnumber.hashCode() : 0;
        result = 31 * result + (accounttype != null ? accounttype.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + userid;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + currency;
        result = 31 * result + depositstatus;
        result = 31 * result + (int) (availablebalance ^ (availablebalance >>> 32));
        result = 31 * result + (int) (blockamount ^ (blockamount >>> 32));
        result = 31 * result + (branchcode != null ? branchcode.hashCode() : 0);
        result = 31 * result + id;
        return result;
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
    @Column(name = "updatedate")
    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }
}
