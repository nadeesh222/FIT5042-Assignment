/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nadeesh
 */
@Entity
@Table(name = "project_donations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectDonations.findAll", query = "SELECT p FROM ProjectDonations p")
    , @NamedQuery(name = "ProjectDonations.findByProjid", query = "SELECT p FROM ProjectDonations p WHERE p.projectDonationsPK.projid = :projid")
    , @NamedQuery(name = "ProjectDonations.findByDonid", query = "SELECT p FROM ProjectDonations p WHERE p.projectDonationsPK.donid = :donid")
    , @NamedQuery(name = "ProjectDonations.findByDonDate", query = "SELECT p FROM ProjectDonations p WHERE p.projectDonationsPK.donDate = :donDate")
    , @NamedQuery(name = "ProjectDonations.findByAmount", query = "SELECT p FROM ProjectDonations p WHERE p.amount = :amount")})
public class ProjectDonations implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectDonationsPK projectDonationsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "donid", referencedColumnName = "donid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Donor donor;
    @JoinColumn(name = "projid", referencedColumnName = "projid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public ProjectDonations() {
    }

    public ProjectDonations(ProjectDonationsPK projectDonationsPK) {
        this.projectDonationsPK = projectDonationsPK;
    }

    public ProjectDonations(int projid, int donid, String donDate) {
        this.projectDonationsPK = new ProjectDonationsPK(projid, donid, donDate);
    }

    public ProjectDonationsPK getProjectDonationsPK() {
        return projectDonationsPK;
    }

    public void setProjectDonationsPK(ProjectDonationsPK projectDonationsPK) {
        this.projectDonationsPK = projectDonationsPK;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectDonationsPK != null ? projectDonationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDonations)) {
            return false;
        }
        ProjectDonations other = (ProjectDonations) object;
        if ((this.projectDonationsPK == null && other.projectDonationsPK != null) || (this.projectDonationsPK != null && !this.projectDonationsPK.equals(other.projectDonationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hms.entities.ProjectDonations[ projectDonationsPK=" + projectDonationsPK + " ]";
    }
    
}
