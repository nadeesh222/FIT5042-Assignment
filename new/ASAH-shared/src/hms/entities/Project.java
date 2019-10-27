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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findmaxId", query = "SELECT max(p.projid) FROM Project p ")
    ,
   
    @NamedQuery(name = "Project.findAllAsc", query = "SELECT p FROM Project p where p.status=1 order by p.projid ")
    ,
 
    @NamedQuery(name = "Project.findAllDesc", query = "SELECT p FROM Project p where p.status=1 order by p.projid desc")
    ,
   
      @NamedQuery(name = "Project.searchproject", query = "SELECT p.NAME ,p.DESCRIPTION,d.NAME,p.BUDGET FROM HMSDB.DONOR d,HMSDB.PROJECT p where d.DONID=p.DONID and upper(p.name) like '%:qry%' and  upper(p.DESCRIPTION)like '%:qry%'")
    ,
   
    
   @NamedQuery(name = "Project.findByProjid", query = "SELECT p FROM Project p WHERE p.projid = :projid")
    , @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name")
    , @NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description")
    , @NamedQuery(name = "Project.findByBudget", query = "SELECT p FROM Project p WHERE p.budget = :budget")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "projid")
    private Integer projid;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 150)
    @Column(name = "description")
    private String description;
    @Column(name = "budget")
    private Double budget;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<ProjectDonations> projectDonationsCollection;
    @JoinColumn(name = "donid", referencedColumnName = "donid")
    @ManyToOne
    private Donor donid;
    @OneToOne(mappedBy = "projid")
    private Employee employee;
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

    public Donor getDonid() {
        return donid;
    }

    public void setDonid(Donor donid) {
        this.donid = donid;
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

    public Project() {
    }

    public Project(Integer projid) {
        this.projid = projid;
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

    @XmlTransient
    public Collection<ProjectDonations> getProjectDonationsCollection() {
        return projectDonationsCollection;
    }

    public void setProjectDonationsCollection(Collection<ProjectDonations> projectDonationsCollection) {
        this.projectDonationsCollection = projectDonationsCollection;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


     
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projid != null ? projid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projid == null && other.projid != null) || (this.projid != null && !this.projid.equals(other.projid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hms.entities.Project[ projid=" + projid + " ]";
    }

}
