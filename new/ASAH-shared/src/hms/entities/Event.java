/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findmaxId", query = "SELECT max(e.eventid) FROM Event e where e.status=1 "),
     @NamedQuery(name = "Event.findAllAsc", query = "SELECT e FROM Event e where e.status=1 order by e.eventid "),
    @NamedQuery(name = "Event.findAllDesc", query = "SELECT e FROM Event e where e.status=1 order by e.eventid desc"),
   
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByEventid", query = "SELECT e FROM Event e WHERE e.eventid = :eventid")
    , @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Event.findByDescription", query = "SELECT e FROM Event e WHERE e.description = :description")
    , @NamedQuery(name = "Event.findByScheduleDate", query = "SELECT e FROM Event e WHERE e.scheduleDate = :scheduleDate")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "eventid")
    private Integer eventid;
    @Size(max = 50)
    @Column(name = "event_name")
    private String eventName;
    @Size(max = 8000)
    @Column(name = "description")
    private String description;
     @Column(name = "SCHEDULE_DATE")
    @Temporal(TemporalType.DATE)
    private Date scheduleDate;
   @OneToMany(mappedBy = "eventid")
    private Collection<ExternalUser> externalUserCollection;
    @OneToOne(mappedBy = "eventid")
    private Employee handledBy;

      @Transient
    boolean editable;
    @Transient
    private boolean updateButtonOn = false;
    @Transient
    private boolean editButtonOn = true;
    @Column(name = "status")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

   

    public Event(Integer eventid, String eventName, String description, Date scheduleDate, Employee handledBy, boolean editable, int status) {
        this.eventid = eventid;
        this.eventName = eventName;
        this.description = description;
        this.scheduleDate = scheduleDate;
        this.handledBy = handledBy;
        this.editable = editable;
        
    }
    
    

    public Event(Integer eventid) {
        this.eventid = eventid;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    

    @XmlTransient
    public Collection<ExternalUser> getExternalUserCollection() {
        return externalUserCollection;
    }

    public void setExternalUserCollection(Collection<ExternalUser> externalUserCollection) {
        this.externalUserCollection = externalUserCollection;
    }

    public Employee getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(Employee handledBy) {
        this.handledBy = handledBy;
    }

    public Event() {
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventid != null ? eventid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventid == null && other.eventid != null) || (this.eventid != null && !this.eventid.equals(other.eventid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hms.entities.Event[ eventid=" + eventid + " ]";
    }
    
}
