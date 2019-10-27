/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Guan
 */


 import java.util.ArrayList;
import javax.el.ELContext;

 import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
 import javax.faces.component.UIComponent;
 import javax.faces.context.FacesContext;
 import javax.faces.convert.Converter;
 import javax.faces.convert.ConverterException;
 import javax.faces.convert.FacesConverter;
import mbeans.EventManagerBean;

 @FacesConverter(forClass = hms.entities.Event.class,value="convertEvent")
 
 public class EventConvertor implements Converter{
    @ManagedProperty(value="#{eventManagerBean}") 
    EventManagerBean eventManagerBean;
    
    public ArrayList<hms.entities.Event> eventDb; //= propertyManagedBean.getAllContactPeople();

    public EventConvertor() 
    {
        try
        {
            //instantiate propertyManagedBean
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            eventManagerBean = (EventManagerBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "eventManagerBean");

            eventDb = eventManagerBean.getAllEvents();
        }
        catch(Exception ex)
        {
            
        }
    }
                       
    //this method is for converting the submittedValue (here it means the contact person id) to the contact person object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the contact person object, but the id.
    public hms.entities.Event getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (hms.entities.Event e : eventDb) {
                    if (e.getEventid()== number) {
                        return e;
                    }
                }

            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid contact person"));
            }
        }

        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((hms.entities.Event) value).getEventid());
        }
    }
}
