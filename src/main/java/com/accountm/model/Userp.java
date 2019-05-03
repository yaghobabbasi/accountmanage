package com.accountm.model;

import javax.persistence.*;

/**
 * Created by yaghobabbai on 2/1/2019.
 */
@Entity
public class Userp {
    private int id;
    private String firstname;
    private String lastname;
    private String fathername;
    private String nationalcode;
    private String customernumber;
    private String phonenumber;
    private String mobilenumber;
    private String birthdate;
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "judgements_id_seq")
   // @SequenceGenerator(name = "judgements_id_seq", sequenceName = "judgements_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "fathername")
    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Basic
    @Column(name = "nationalcode")
    public String getNationalcode() {
        return nationalcode;
    }

    public void setNationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
    }

    @Basic
    @Column(name = "customernumber")
    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    @Basic
    @Column(name = "phonenumber")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Basic
    @Column(name = "mobilenumber")
    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    @Basic
    @Column(name = "birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userp userp = (Userp) o;

        if (id != userp.id) return false;
        if (firstname != null ? !firstname.equals(userp.firstname) : userp.firstname != null) return false;
        if (lastname != null ? !lastname.equals(userp.lastname) : userp.lastname != null) return false;
        if (fathername != null ? !fathername.equals(userp.fathername) : userp.fathername != null) return false;
        if (nationalcode != null ? !nationalcode.equals(userp.nationalcode) : userp.nationalcode != null) return false;
        if (customernumber != null ? !customernumber.equals(userp.customernumber) : userp.customernumber != null)
            return false;
        if (phonenumber != null ? !phonenumber.equals(userp.phonenumber) : userp.phonenumber != null) return false;
        if (mobilenumber != null ? !mobilenumber.equals(userp.mobilenumber) : userp.mobilenumber != null) return false;
        if (birthdate != null ? !birthdate.equals(userp.birthdate) : userp.birthdate != null) return false;
        if (address != null ? !address.equals(userp.address) : userp.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (fathername != null ? fathername.hashCode() : 0);
        result = 31 * result + (nationalcode != null ? nationalcode.hashCode() : 0);
        result = 31 * result + (customernumber != null ? customernumber.hashCode() : 0);
        result = 31 * result + (phonenumber != null ? phonenumber.hashCode() : 0);
        result = 31 * result + (mobilenumber != null ? mobilenumber.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
