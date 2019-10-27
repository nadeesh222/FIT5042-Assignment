/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Nadeesh
 */
@RequestScoped
@Named(value = "donManage")
public class Donor implements Serializable {

    private Integer donid;
    private String name;
    private String address;
    private String contactno;
    boolean editable;
    private int status;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Donor() {
    }

    public Donor(Integer donid) {
        this.donid = donid;
    }

    public Integer getDonid() {
        return donid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Donor(Integer donid, String name, String address, String contactno) {
        this.donid = donid;
        this.name = name;
        this.address = address;
        this.contactno = contactno;
    }

    public void setDonid(Integer donid) {
        this.donid = donid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

}
