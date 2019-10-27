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
@Named(value = "projManage")
public class Project implements Serializable {

    private Integer projid;
    private String name;
    private String description;
    private Double budget;
    private Donor donid;
    private String donName;

    public void setDonName(String donName) {
        this.donName = donName;
    }

    public String getDonName() {
        return donName;
    }
    
    public Integer getProjid() {
        return projid;
    }

    public void setProjid(Integer projid) {
        this.projid = projid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Donor getDonid() {
        return donid;
    }

    public void setDonid(Donor donid) {
        this.donid = donid;
    }

}
