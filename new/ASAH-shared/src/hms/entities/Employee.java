/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nadeesh
 */
@Entity
@Table(name = "employee")
@DiscriminatorValue(value = "W")
@PrimaryKeyJoinColumn(name="pid")
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "RID")
    private Integer rid;
    @Column(name = "empno")
    private Integer empno;
    @Column(name = "ext")
    private Integer ext;
    @Size(max = 20)
    @Column(name = "role")
    private String role;
    @JoinColumn(name = "eventid", referencedColumnName = "eventid")
    @OneToOne
    private Event eventid;
    @JoinColumn(name = "projid", referencedColumnName = "projid")
    @OneToOne
    private Project projid;

    public Employee() {
    }

    public Employee(Integer empno, Integer ext, String role, Event eventid, Project projid) {
        this.empno = empno;
        this.ext = ext;
        this.role = role;
        this.eventid = eventid;
        this.projid = projid;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Integer getExt() {
        return ext;
    }

    public void setExt(Integer ext) {
        this.ext = ext;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Event getEventid() {
        return eventid;
    }

    public void setEventid(Event eventid) {
        this.eventid = eventid;
    }

    public Project getProjid() {
        return projid;
    }

    public void setProjid(Project projid) {
        this.projid = projid;
    }
 

     
    
}
