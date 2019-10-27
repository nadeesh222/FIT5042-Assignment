/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hms.entities.Employee;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Nadeesh
 */
@RequestScoped
@Named(value = "eveManage")
public class Event {

    Integer eventid;
    String eventName;
    String description;
    Date scheduleDate;
    Employee handledBy;
    int status;

    public Event(Integer eventid, String eventName, String description, Date scheduleDate, Employee handledBy, int status) {
        this.eventid = eventid;
        this.eventName = eventName;
        this.description = description;
        this.scheduleDate = scheduleDate;
        this.handledBy = handledBy;
        this.status = status;
    }

    public Event() {
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

    public Employee getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(Employee handledBy) {
        this.handledBy = handledBy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
