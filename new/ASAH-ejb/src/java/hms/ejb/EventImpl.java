/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.ejb;

import hms.entities.Donor;
import hms.entities.Event;
import hms.entities.Event;
import hms.entities.Project;
import hms.interfaces.EventInt;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Nadeesh
 */
@Stateless
public class EventImpl implements EventInt {

    @PersistenceContext(unitName = "HMS-ejbPU")
    private EntityManager entityManager;

    @Override
    public void createEvent(Event event) {
        int eventId = findMaxEventId();
        event.setEventid(eventId + 1);
        entityManager.persist(event);

    }

    @Override
    public int findMaxEventId() {
        int maxid = 0;
        try {
            maxid = Integer.parseInt(entityManager.createNamedQuery("Event.findmaxId").getSingleResult().toString());
        } catch (Exception ex) {

        }
        return maxid;
    }

    @Override
    public void updateEvent(Event event) {
        entityManager.merge(event);
     }
   

    @Override
    public List<Event> getAllEventsDesc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getAllEventsAsc() {
 List<Event> eventList = null;
        
        try {

                   eventList = entityManager.createNamedQuery("Event.findAllAsc").getResultList();


        } catch (Exception ex) {
            String y = "";
        }
        return eventList;
    }

    @Override
    public Donor getEventByEventId(int donId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
