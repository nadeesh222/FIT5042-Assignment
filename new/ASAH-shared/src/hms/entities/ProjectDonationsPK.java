/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nadeesh
 */
@Embeddable
public class ProjectDonationsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "projid")
    private int projid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "donid")
    private int donid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "don_date")
    private String donDate;

    public ProjectDonationsPK() {
    }

    public ProjectDonationsPK(int projid, int donid, String donDate) {
        this.projid = projid;
        this.donid = donid;
        this.donDate = donDate;
    }

    public int getProjid() {
        return projid;
    }

    public void setProjid(int projid) {
        this.projid = projid;
    }

    public int getDonid() {
        return donid;
    }

    public void setDonid(int donid) {
        this.donid = donid;
    }

    public String getDonDate() {
        return donDate;
    }

    public void setDonDate(String donDate) {
        this.donDate = donDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projid;
        hash += (int) donid;
        hash += (donDate != null ? donDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDonationsPK)) {
            return false;
        }
        ProjectDonationsPK other = (ProjectDonationsPK) object;
        if (this.projid != other.projid) {
            return false;
        }
        if (this.donid != other.donid) {
            return false;
        }
        if ((this.donDate == null && other.donDate != null) || (this.donDate != null && !this.donDate.equals(other.donDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hms.entities.ProjectDonationsPK[ projid=" + projid + ", donid=" + donid + ", donDate=" + donDate + " ]";
    }
    
}
