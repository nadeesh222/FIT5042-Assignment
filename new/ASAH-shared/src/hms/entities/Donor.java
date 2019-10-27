/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nadeesh
 */
@Entity
@Table(name = "donor")
@XmlRootElement
@NamedQueries({
    
     @NamedQuery(name = "Donor.findmaxId", query = "SELECT max(d.donid) FROM Donor d "),
   
    @NamedQuery(name = "Donor.findAllAsc", query = "SELECT d FROM Donor d where d.status=1 order by d.donid ")
    ,
   
    @NamedQuery(name = "Donor.findAllDesc", query = "SELECT d FROM Donor d where d.status=1 order by d.donid desc")
    , @NamedQuery(name = "Donor.findByDonid", query = "SELECT d FROM Donor d WHERE d.donid = :donid")
    , @NamedQuery(name = "Donor.findByName", query = "SELECT d FROM Donor d WHERE d.name = :name")
    , @NamedQuery(name = "Donor.findByAddress", query = "SELECT d FROM Donor d WHERE d.address = :address")
    , @NamedQuery(name = "Donor.findByContactno", query = "SELECT d FROM Donor d WHERE d.contactno = :contactno")})
public class Donor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "donid")
    private Integer donid;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 10)
    @Column(name = "contactno")
    private String contactno;
  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donor")
    private Collection<ProjectDonations> projectDonationsCollection;
    @OneToMany(mappedBy = "donid")
    private Collection<Project> projectCollection;
    
    @Transient
    boolean editable;
    @Transient
    private boolean updateButtonOn = false;
    @Transient
    private boolean editButtonOn = true;
    @Column(name = "status")
    private int status;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    //buttons
    public boolean isUpdateButtonOn() {
        return updateButtonOn;
    }

    public void setUpdateButtonOn(boolean updateButtonOn) {
        this.updateButtonOn = updateButtonOn;
    }

    public boolean isEditButtonOn() {
        return editButtonOn;
    }

    public void setEditButtonOn(boolean editButtonOn) {
        this.editButtonOn = editButtonOn;
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
        editable = true;
    }

    public Donor() {
    }

    public Donor(Integer donid) {
        this.donid = donid;
    }

    public Integer getDonid() {
        return donid;
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

    @XmlTransient
    public Collection<ProjectDonations> getProjectDonationsCollection() {
        return projectDonationsCollection;
    }

    public void setProjectDonationsCollection(Collection<ProjectDonations> projectDonationsCollection) {
        this.projectDonationsCollection = projectDonationsCollection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donid != null ? donid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donor)) {
            return false;
        }
        Donor other = (Donor) object;
        if ((this.donid == null && other.donid != null) || (this.donid != null && !this.donid.equals(other.donid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hms.entities.Donor[ donid=" + donid + " ]";
    }

    public void updateDonor(Donor donor) {
        // entityManager.merge(donor);
    }

}
