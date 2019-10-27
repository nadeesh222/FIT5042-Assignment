/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import hms.entities.Donor;
import hms.entities.Employee;
import hms.entities.Event;
import hms.interfaces.EmployeeInt;
import hms.interfaces.EventInt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author Nadeesh
 */
@ManagedBean(name = "eventManagerBean")
@SessionScoped
public class EventManagerBean {

    @EJB
    EventInt eventInt;
    private ArrayList<Event> events;
    private int eventId;
    private Event event;

    public EventInt getEventInt() {
        return eventInt;
    }

    public void setEventInt(EventInt eventInt) {
        this.eventInt = eventInt;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    
 public void addEvent( String eventName, String description, String  scheduleDate1, Employee handledBy) { 

        try {

            Event d = new Event();
            
             Date scheduleDate=new SimpleDateFormat("dd/MM/yyyy").parse(scheduleDate1);  
    
            d.setEventName(eventName);
            d.setDescription(description);
            d.setScheduleDate(scheduleDate);
            d.setHandledBy(handledBy);
            
            
            
            
            setEvents(null);//to reload all events fromm database
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

//    public ArrayList<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(ArrayList<Event> events) {
//        this.events = events;
//    }
//public Event getEventByDonId(int donid){
//   return  eventInt.getEventByDonId(donid);
//
//}
    public ArrayList<Event> getAllEvents() {
        try {

            if (events == null) {
                List<Event> l = eventInt.getAllEventsAsc();

                events = new ArrayList<Event>();

                if (l != null) {
                    for (int i = 0; i < l.size(); i++) {
                        events.add(l.get(i));
                    }

                    return events;
                } else {
                    return null;
                }

            }
            return events;

        } catch (Exception ex) {
            Logger.getLogger(EventManagerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void cancelAction(Event e) {
        e.setEditable(false);

        e.setUpdateButtonOn(false);
        e.setEditButtonOn(true);

    }

    public void updateAction(Event e) {
        e.setEditable(false);
        e.setUpdateButtonOn(false);
        e.setEditButtonOn(true);
        eventInt.updateEvent(e);//Updating the event
    }

    public void deleteAction(Event e) {
        if (e != null) {
            e.setEditable(false);
            e.setUpdateButtonOn(false);
            e.setEditButtonOn(true);
            e.setStatus(0);
            eventInt.updateEvent(e);//Updating the event
            setEvents(null);
        }
    }

    public void editAction(Event d) {
        if (d != null) {
            d.setEditable(true);
            d.setUpdateButtonOn(true);
            d.setEditButtonOn(false);
        }
    }

}

    
    
 