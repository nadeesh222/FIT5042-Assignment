/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.interfaces;

import hms.entities.Donor;
import hms.entities.Event;
import java.util.List;

/**
 *
 * @author Nadeesh
 */
public interface EventInt {

    public void createEvent(Event event);

    public int findMaxEventId();
    
    
    void updateEvent(Event event);
    List<Event> getAllEventsDesc();
    List<Event> getAllEventsAsc();
    Donor getEventByEventId(int donId);
}
